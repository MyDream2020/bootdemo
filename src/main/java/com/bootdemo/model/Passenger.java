package com.bootdemo.model;

import com.bootdemo.domain.TicketType;

import java.math.BigDecimal;

/**
 * @Author: ASUS
 * @Date: 2020/5/7 15:48
 * @Version: 1.0
 */
public class Passenger {

    private String userName;
    private String cardId;
    /**
     * seatGradeInfo 包含3部分信息：typeId Price seatGrade
     */
    private String seatGradeInfo;
    private TicketType ticketType;
    private byte isAdult;

    public Passenger(String userName, String cardId, String seatGradeInfo, byte isAdult) {
        this.userName = userName;
        this.cardId = cardId;
        this.seatGradeInfo = seatGradeInfo;
        this.isAdult = isAdult;
    }

    public Passenger() {
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSeatGradeInfo() {
        return seatGradeInfo;
    }

    public void setSeatGradeInfo(String seatGradeInfo) {
        this.seatGradeInfo = seatGradeInfo;
    }

    public byte getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(byte isAdult) {
        this.isAdult = isAdult;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "userName='" + userName + '\'' +
                ", cardId='" + cardId + '\'' +
                ", seatGradeInfo='" + seatGradeInfo + '\'' +
                ", isAdult=" + isAdult +
                ", ticketType=" + ticketType +
                '}';
    }
}
