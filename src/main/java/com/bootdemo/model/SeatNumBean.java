package com.bootdemo.model;

import java.math.BigDecimal;

/**
 * @Author: ASUS
 * @Date: 2020/5/7 16:30
 * @Version: 1.0
 */
public class SeatNumBean{
    private int ticketTypeId;
    private int num;

    private BigDecimal price;

    public SeatNumBean(int ticketTypeId, int num, BigDecimal price) {
        this.ticketTypeId = ticketTypeId;
        this.num = num;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SeatNumBean{" +
                "ticketTypeId=" + ticketTypeId +
                ", num=" + num +
                '}';
    }
}
