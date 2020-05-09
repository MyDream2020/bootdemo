package com.bootdemo.model;

import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/5/7 15:46
 * @Version: 1.0
 */
public class TemporaryOrders {
    private int userId;
    private int sectionId;
    private List<Passenger> passengers;

    public TemporaryOrders(int userId, int sectionId, List<Passenger> passengers) {
        this.userId = userId;
        this.sectionId = sectionId;
        this.passengers = passengers;
    }

    public TemporaryOrders() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "TemporaryOrders{" +
                "userId=" + userId +
                ", sectionId=" + sectionId +
                ", passenger=" + passengers +
                '}';
    }
}
