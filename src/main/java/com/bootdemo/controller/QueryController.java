package com.bootdemo.controller;

import com.bootdemo.dao.OrdersMapper;
import com.bootdemo.dao.TicketMapper;
import com.bootdemo.dao.TicketTypeMapper;
import com.bootdemo.dao.TrainSectionMapper;
import com.bootdemo.domain.*;
import com.bootdemo.model.DisplayOrders;
import com.bootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/5/5 19:34
 * @Version: 1.0
 */
@Controller
public class QueryController {
    private TrainSectionMapper sectionMapper;
    private TicketMapper ticketMapper;
    private OrdersMapper ordersMapper;
    private TicketTypeMapper typeMapper;
    private RedisUtil redisUtil;
    private HttpSession session;
    @Autowired
    public QueryController(TrainSectionMapper sectionMapper, TicketMapper ticketMapper,
                            OrdersMapper ordersMapper, TicketTypeMapper typeMapper,
                           HttpSession session,RedisUtil redisUtil) {
        this.sectionMapper = sectionMapper;
        this.ticketMapper = ticketMapper;
        this.ordersMapper = ordersMapper;
        this.typeMapper = typeMapper;
        this.redisUtil = redisUtil;
        this.session = session;
    }

    @RequestMapping("/query/query.do")
    public String doQuery(String startSection, String endSection,String startTime){
        DateTimeFormatter input = DateTimeFormatter.ofPattern("yyyy-M-d");
        DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        startTime = LocalDate.parse(startTime,input).format(output);
        List<TrainSection> results = sectionMapper.selectTrainSectionByTimeAndPlace(startSection, endSection, startTime);
        for (TrainSection result : results) {
            redisUtil.set(String.valueOf(result.getSectionId()), result, 30);
        }
        session.setAttribute("queryList", results);
        return "queryResult";
    }

    @RequestMapping("/query/personal.do")
    public String doPersonal(String content, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        if ("logout".equals(content)){
            session.removeAttribute("user");
            return "redirect:/login/login.html";
        } else if ("orders".equals(content)){
            List<DisplayOrders> displayOrders = (List<DisplayOrders>) redisUtil.get("userIdQuery"+user.getUserId());
            if (displayOrders == null){
                displayOrders = new ArrayList<>();
                List<Orders> ordersList = ordersMapper.selectOrdersByUserIdIsPay(user.getUserId(),(byte) 1);
                for (Orders orders : ordersList) {
                    TrainSection section = (TrainSection) redisUtil.get(String.valueOf(orders.getSectionId()));
                    if (section == null){
                        section = sectionMapper.selectTrainSection(orders.getSectionId());
                        redisUtil.set(String.valueOf(section.getSectionId()), section, 30);
                    }
                    Ticket ticket = ticketMapper.selectTicket(orders.getTicketId());
                    TicketType type = (TicketType) redisUtil.get("typeId"+ ticket.getTypeId());
                    if (type == null){
                        type = typeMapper.selectTicketType(ticket.getTypeId());
                    }

                    redisUtil.set("typeId"+ ticket.getTypeId(), type, 30);
                    String seatGrade = type.getSeatGrade();
                    BigDecimal price = type.getPrice();
                    if (orders.getIsAdule() == 0){
                        price = price.multiply(new BigDecimal("0.75"));
                    }
                    displayOrders.add(new DisplayOrders(
                            section, orders, ticket, seatGrade, price));
                }
            }
            redisUtil.set("userIdQuery"+user.getUserId(), displayOrders, 5);
            model.addAttribute("displayOrders", displayOrders);
        }
        return "ajaxDisplay";
    }
}
