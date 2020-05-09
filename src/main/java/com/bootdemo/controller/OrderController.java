package com.bootdemo.controller;

import com.bootdemo.dao.OrdersMapper;
import com.bootdemo.dao.TicketMapper;
import com.bootdemo.dao.TicketTypeMapper;
import com.bootdemo.dao.TrainTypeMapper;
import com.bootdemo.domain.*;
import com.bootdemo.model.Passenger;
import com.bootdemo.model.TemporaryOrders;
import com.bootdemo.model.TicketInfoBean;
import com.bootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/4/8 22:34
 * @Version: 1.0
 */
@SuppressWarnings("AlibabaMethodReturnWrapperType")
@Controller
public class OrderController {

    private TicketTypeMapper ticketTypeMapper;
    private TrainTypeMapper trainTypeMapper;
    private OrdersMapper ordersMapper;
    private TicketMapper ticketMapper;

    private RedisUtil redisUtil;
    private HttpSession session;

    @Autowired
    public OrderController(TicketTypeMapper ticketTypeMapper, RedisUtil redisUtil,OrdersMapper ordersMapper,
                           TrainTypeMapper trainTypeMapper, TicketMapper ticketMapper, HttpSession session) {
        this.ticketTypeMapper = ticketTypeMapper;
        this.redisUtil = redisUtil;
        this.session = session;
        this.ordersMapper = ordersMapper;
        this.trainTypeMapper = trainTypeMapper;
        this.ticketMapper = ticketMapper;
    }

    @RequestMapping("/orders/preorder.do")
    public String doPreOrders(Integer sectionId, Model model){

        List<TrainSection> results = (List<TrainSection>) session.getAttribute("queryList");
        TrainSection section = null;
        User user = (User) session.getAttribute("user");
        for (TrainSection result : results) {
            if (result.getSectionId() == sectionId){
                section = result;
                break;
            }
        }

        //TODO 设置一个专门的error页面
        if (section == null || user == null){
            return "loginError";
        }
        String way = trainTypeMapper.selectTrainWay(section.getTrainId());
        TicketInfoBean infoBean = new TicketInfoBean(section,way);
        List<Integer> ticketTypeIdList = ticketTypeMapper.selectTypeIdListBySectionId(sectionId);
        List<TicketType> ticketTypes = new ArrayList<>();
        for (Integer typeId : ticketTypeIdList) {
            TicketType type = getTicketType(typeId);
            ticketTypes.add(type);
        }
        infoBean.setTicketTypes(ticketTypes);
        model.addAttribute("info", infoBean);
        session.setAttribute("section", section);
        return "/makeOrders";
    }


    private TicketType getTicketType(int ticketTypeId){
        String id = String.valueOf(ticketTypeId);
        TicketType type = null;
        try {
            type = (TicketType) redisUtil.get("typeId" + id);
            Integer seatNum = (Integer) redisUtil.get("typeNum"+ id);
            if (type != null && seatNum != null){
                type.setAllSeatNum(seatNum);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (type == null){
            type = ticketTypeMapper.selectTicketType(ticketTypeId);
            redisUtil.set("typeNum"+ id, type.getAllSeatNum(), 30);
            redisUtil.set("typeId" + id, type,10);
        }
        return type;
    }

    @RequestMapping("/orders/generate.do")
    public String doMakeOrders(TemporaryOrders temporaryorders, Model model){
        BigDecimal sum = totalCalculationAndStoredOrders(temporaryorders);
        model.addAttribute("price", sum.toString());
        TrainSection section = (TrainSection) session.getAttribute("section");
        model.addAttribute("section", section);
        model.addAttribute("passengers", temporaryorders.getPassengers());
        return "/payment";
    }

    private BigDecimal totalCalculationAndStoredOrders(TemporaryOrders temporaryorders) {
        List<Orders> ordersList = new ArrayList<>();
        BigDecimal sum = new BigDecimal("0.0");
        List<Passenger> passengers = temporaryorders.getPassengers();
        List<Integer> typeIdList = new ArrayList<>();
        for (Passenger passenger : passengers) {
            Orders notPayOrders = new Orders();
            TicketType infoToTicketType = getTicketType(passenger);
            typeIdList.add(infoToTicketType.getTypeId());
            BigDecimal temp = infoToTicketType.getPrice();
            if (passenger.getIsAdult() == 0){
                temp = temp.multiply(new BigDecimal("0.75"));
                infoToTicketType.setPrice(temp);
            }
            passenger.setTicketType(infoToTicketType);
            sum = sum.add(temp);
            //redisUtil.set("cardId" + passenger.getCardId(), infoToTicketType, 15);
            notPayOrders.setUserId(temporaryorders.getUserId());
            notPayOrders.setSectionId(temporaryorders.getSectionId());
            notPayOrders.setUserName(passenger.getUserName());
            notPayOrders.setCardId(passenger.getCardId());
            notPayOrders.setIsAdule(passenger.getIsAdult());
            ordersList.add(notPayOrders);
        }
        redisUtil.set("userIdType" + temporaryorders.getUserId(), typeIdList, 15);
        ordersMapper.insertOrdersByList(ordersList);
        redisUtil.set("userIdOrders" + temporaryorders.getUserId(), ordersList, 15);
        return sum;
    }
    private TicketType getTicketType(Passenger passenger) {
        TicketType ticketType = new TicketType();
        String[] info = passenger.getSeatGradeInfo().split(":");
        ticketType.setTypeId(Integer.parseInt(info[0]));
        ticketType.setPrice(new BigDecimal(info[1]));
        ticketType.setSeatGrade(info[2]);
        return ticketType;
    }

    @RequestMapping("/orders/pay.do")
    @ResponseBody
    public String doPayment(String userId) {
        List<Orders> ordersList = (List<Orders>) redisUtil.get("userIdOrders" + userId);
        List<Integer> typeIdList = (List<Integer>) redisUtil.get("userIdType" + userId);
        List<Ticket> ticketList = new ArrayList<>();
        for (Integer typeId  : typeIdList) {
            Ticket ticket = ticketMapper.selectNotSellTicketIdByTicketTypeId(typeId);
            if (ticket == null){
                if (ticketList.size() > 0){
                    ticketMapper.updateTicketForIsSellByList(ticketList, (byte) 0);
                }
                return "支付失败！余票不足！";
            }
            ticketMapper.updateTypeSell(ticket.getTicketId());
            ticketList.add(ticket);
        }
        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders = ordersList.get(i);
            orders.setIsPay((byte) 1);
            orders.setTicketId(ticketList.get(i).getTicketId());
        }
        //TODO ticketType余量表要更新 redis同理
        ordersMapper.updateOrdersForTicketAndSellByList(ordersList);
        redisUtil.set("userIdOrders" + userId, ordersList, 15);
        redisUtil.set("userTicket" + userId, ticketList, 15);
        ticketTypeMapper.updateTypeForDecrByList(typeIdList);
        for (Integer id : typeIdList) {
            redisUtil.decr("typeNum" + id);
        }
        return "success";
    }
}
