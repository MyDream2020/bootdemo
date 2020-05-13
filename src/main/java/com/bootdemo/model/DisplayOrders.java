package com.bootdemo.model;

import com.bootdemo.domain.Orders;
import com.bootdemo.domain.Ticket;
import com.bootdemo.domain.TrainSection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: ASUS
 * @Date: 2020/5/10 22:46
 * @Version: 1.0
 */
public class DisplayOrders implements Serializable {

    private TrainSection section;
    private Orders orders;
    private Ticket ticket;
    private String seatGrade;
    private BigDecimal price;

    public DisplayOrders(TrainSection section, Orders orders, Ticket ticket,
                         String seatGrade, BigDecimal price) {
        this.section = section;
        this.orders = orders;
        this.ticket = ticket;
        this.seatGrade = seatGrade;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public DisplayOrders() {
    }

    public String getSeatGrade() {
        return seatGrade;
    }

    public void setSeatGrade(String seatGrade) {
        this.seatGrade = seatGrade;
    }

    public TrainSection getSection() {
        return section;
    }

    public void setSection(TrainSection section) {
        this.section = section;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

