package com.bootdemo.controller;

import com.bootdemo.dao.*;
import com.bootdemo.domain.Ticket;
import com.bootdemo.domain.TicketType;
import com.bootdemo.domain.TrainSection;
import com.bootdemo.domain.TrainType;
import com.bootdemo.model.SectionListBean;
import com.bootdemo.model.SectionTicketInfo;
import com.bootdemo.model.TypeList;
import com.bootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/5/27 10:15
 * @Version: 1.0
 */

@Controller
public class ConditionController {

    private OrdersMapper ordersMapper;
    private TrainTypeMapper trainTypeMapper;
    private TrainSectionMapper sectionMapper;
    private TicketTypeMapper typeMapper;
    private TicketMapper ticketMapper;
    private RedisUtil redisUtil;
    private HttpSession session;

    @Autowired
    public ConditionController(TrainTypeMapper trainTypeMapper, TrainSectionMapper sectionMapper,
                               TicketTypeMapper typeMapper, TicketMapper ticketMapper,OrdersMapper ordersMapper,
                               RedisUtil redisUtil, HttpSession session) {
        this.ordersMapper = ordersMapper;
        this.trainTypeMapper = trainTypeMapper;
        this.sectionMapper = sectionMapper;
        this.typeMapper = typeMapper;
        this.ticketMapper = ticketMapper;
        this.redisUtil = redisUtil;
        this.session = session;
    }

    @RequestMapping("/train/list.do")
    public String doListTrain(Model model){
        List<TrainType> trainTypes = trainTypeMapper.selectAllForInfo(0,100);
        model.addAttribute("trains", trainTypes);
        return "ajaxList";
    }

    @ResponseBody
    @RequestMapping("/train/add.do")
    public String doAddTrain(TrainType train){
        trainTypeMapper.insertTrainType(train);
        return "        添加成功";
    }

    @RequestMapping("/section/list.do")
    public String doListSection(Model model){
        List<SectionListBean> sectionList = new ArrayList<>();
        List<TrainSection> sections = sectionMapper.selectAllSectionInfo(0,100);
        for (TrainSection section : sections) {
            String trainName =trainTypeMapper.selectName(section.getTrainId());
            sectionList.add(new SectionListBean(section, trainName));
        }
        sectionList.sort(Comparator.comparing(SectionListBean::getTrainName));
        model.addAttribute("sectionList", sectionList);
        return "ajaxList";
    }

    @ResponseBody
    @RequestMapping("/section/add.do")
    public String doAddSection(TrainSection section){
        sectionMapper.insertTrainSection(section);
        return "        添加成功";
    }

    @ResponseBody
    @RequestMapping("/type/add.do")
    public String doAddTicketType(TypeList typeList){
        List<TicketType> types = typeList.getTypes();
        typeMapper.insertTrainTicketTypeByList(types);
        List<Ticket> ticketList = new ArrayList<>();
        int init = 1;
        for (TicketType type : types) {
            int c = type.getCompartmentNum();
            int s = type.getAllSeatNum();
            int p = s / c;
            for (int i = init; i < init + c; i++) {
                for (int j = 1; j <= p; j++) {
                    Ticket ticket = new Ticket();
                    ticket.setCompartmentNum(i);
                    ticket.setSeatingNum(j);
                    ticket.setTypeId(type.getTypeId());
                    ticketList.add(ticket);
                }
            }
            init += c;
        }
        ticketMapper.insertTicketByList(ticketList);

        return "        添加成功";
    }

    @RequestMapping("/ticket/list.do")
    public String doListTicketType(Model model){
        List<TrainSection> sections = sectionMapper.selectAllSectionInfo(0,100);
        List<SectionTicketInfo> infoList = new ArrayList<>();
        for (TrainSection section : sections) {
            TrainType trainType = (TrainType) redisUtil.get("sectionId" + section.getSectionId());
            if (trainType == null){
                trainType = trainTypeMapper.selectTrainType(section.getTrainId());
                redisUtil.set("sectionId"+section.getSectionId(), trainType, 5);
            }
            int id = section.getSectionId();
            int payNum = ordersMapper.selectIsPayNumBySectionId(id);
            int changeNum = ordersMapper.selectIsChangeNumBySectionId(id);
            String trainName = trainType.getTrainName();
            infoList.add(new SectionTicketInfo(section, payNum,changeNum,trainName));
        }
        infoList.sort(Comparator.comparing(SectionTicketInfo::getTrainName));
        model.addAttribute("infoList", infoList);
        return "ajaxList";
    }

}
