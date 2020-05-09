package com.bootdemo.model;

import com.bootdemo.domain.TicketType;
import com.bootdemo.domain.TrainSection;

import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/5/6 9:42
 * @Version: 1.0
 */

public class TicketInfoBean {
    private TrainSection section;
    private String way;
    List<TicketType> ticketTypes;

    public TicketInfoBean(TrainSection section, String way) {
        this.section = section;
        this.way = way;
    }

    public TicketInfoBean() {
    }

    public TrainSection getSection() {
        return section;
    }

    public void setSection(TrainSection section) {
        this.section = section;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    @Override
    public String toString() {
        return "TicketInfoBean{" +
                section.toString() +
                ", way='" + way +
                '}';
    }
}
