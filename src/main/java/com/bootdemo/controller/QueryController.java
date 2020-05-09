package com.bootdemo.controller;

import com.bootdemo.dao.TrainSectionMapper;
import com.bootdemo.dao.TrainTypeMapper;
import com.bootdemo.domain.TrainSection;
import com.bootdemo.domain.TrainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/5/5 19:34
 * @Version: 1.0
 */
@Controller
public class QueryController {
    private TrainSectionMapper sectionMapper;
    private HttpSession session;

    @Autowired
    public QueryController(TrainSectionMapper sectionMapper, HttpSession session) {
        this.sectionMapper = sectionMapper;
        this.session = session;
    }

    @RequestMapping("/query/query.do")
    public String doQuery(String startSection, String endSection,String startTime){
        DateTimeFormatter input = DateTimeFormatter.ofPattern("yyyy-M-d");
        DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        startTime = LocalDate.parse(startTime,input).format(output);
        List<TrainSection> results = sectionMapper.selectTrainSectionByTimeAndPlace(startSection, endSection, startTime);
        session.setAttribute("queryList", results);
        return "queryResult";
    }



}
