package com.bootdemo.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class Orders implements Serializable {
    private int orderId;
    private int userId;
    private String cardId;
    private String userName;
    private int sectionId;
    private int ticketId;
    private byte isAdule;
    private byte isPay;
    private byte isChange;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public byte getIsAdule() {
        return isAdule;
    }

    public void setIsAdule(byte isAdule) {
        this.isAdule = isAdule;
    }

    public byte getIsPay() {
        return isPay;
    }

    public void setIsPay(byte isPay) {
        this.isPay = isPay;
    }

    public byte getIsChange() {
        return isChange;
    }

    public void setIsChange(byte isChange) {
        this.isChange = isChange;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", cardId='" + cardId + '\'' +
                ", userName='" + userName + '\'' +
                ", sectionId=" + sectionId +
                ", ticketId=" + ticketId +
                ", isAdule=" + isAdule +
                ", isPay=" + isPay +
                ", isChange=" + isChange +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId &&
                userId == orders.userId &&
                sectionId == orders.sectionId &&
                ticketId == orders.ticketId &&
                isAdule == orders.isAdule &&
                isPay == orders.isPay &&
                isChange == orders.isChange &&
                Objects.equals(cardId, orders.cardId) &&
                Objects.equals(userName, orders.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, cardId, userName, sectionId, ticketId, isAdule, isPay, isChange);
    }
}
