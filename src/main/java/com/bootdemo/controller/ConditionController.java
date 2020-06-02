package com.bootdemo.controller;

import com.bootdemo.dao.TicketMapper;
import com.bootdemo.dao.TicketTypeMapper;
import com.bootdemo.dao.TrainSectionMapper;
import com.bootdemo.dao.TrainTypeMapper;
import com.bootdemo.domain.TicketType;
import com.bootdemo.domain.TrainSection;
import com.bootdemo.domain.TrainType;
import com.bootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: ASUS
 * @Date: 2020/5/27 10:15
 * @Version: 1.0
 */

@Controller
public class ConditionController {
    private TrainTypeMapper trainTypeMapper;
    private TrainSectionMapper sectionMapper;
    private TicketTypeMapper typeMapper;
    private TicketMapper ticketMapper;
    private RedisUtil redisUtil;
    private HttpSession session;

    @Autowired
    public ConditionController(TrainTypeMapper trainTypeMapper, TrainSectionMapper sectionMapper,
                               TicketTypeMapper typeMapper, TicketMapper ticketMapper,
                               RedisUtil redisUtil, HttpSession session) {
        this.trainTypeMapper = trainTypeMapper;
        this.sectionMapper = sectionMapper;
        this.typeMapper = typeMapper;
        this.ticketMapper = ticketMapper;
        this.redisUtil = redisUtil;
        this.session = session;
    }

    @RequestMapping("/train/add.do")
    public String doAddTrain(TrainType train){
        System.out.println(train);
        trainTypeMapper.insertTrainType(train);
        return "redirect:/login/login.html";
    }

    @RequestMapping("/section/add.do")
    public String doAddSection(TrainSection section){
        System.out.println(section);
        sectionMapper.insertTrainSection(section);
        return "redirect:/login/login.html";
    }

    @RequestMapping("/type/add.do")
    public String doAddTicketType(TicketType type){
        System.out.println(type);
        typeMapper.insertTicketType(type);
        return "redirect:/login/login.html";
    }
}
