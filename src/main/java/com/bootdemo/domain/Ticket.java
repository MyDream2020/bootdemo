package com.bootdemo.domain;

import java.util.Objects;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class Ticket {
    private int ticketId;
    private int typeId;
    private int compartmentNum;
    private int seatingNum;
    private byte isSell = 0;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCompartmentNum() {
        return compartmentNum;
    }

    public void setCompartmentNum(int compartmentNum) {
        this.compartmentNum = compartmentNum;
    }

    public int getSeatingNum() {
        return seatingNum;
    }

    public void setSeatingNum(int seatingNum) {
        this.seatingNum = seatingNum;
    }

    public byte getIsSell() {
        return isSell;
    }

    public void setIsSell(byte isSell) {
        this.isSell = isSell;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", typeId=" + typeId +
                ", compartmentNum=" + compartmentNum +
                ", seatingNum=" + seatingNum +
                ", isSell=" + isSell +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId &&
                typeId == ticket.typeId &&
                compartmentNum == ticket.compartmentNum &&
                seatingNum == ticket.seatingNum &&
                isSell == ticket.isSell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, typeId, compartmentNum, seatingNum, isSell);
    }
}
