package com.bootdemo.model;

import com.bootdemo.domain.TrainSection;
import com.bootdemo.domain.TrainType;

/**
 * @Author: ASUS
 * @Date: 2020/6/2 22:13
 * @Version: 1.0
 */
public class SectionTicketInfo {

    private TrainSection section;
    private int payNum;
    private int changeNum;
    private String trainName;
    private int allNum;

    public SectionTicketInfo(TrainSection section, int payNum, int changeNum, String trainName, int allNum) {
        this.section = section;
        this.payNum = payNum;
        this.changeNum = changeNum;
        this.trainName = trainName;
        this.allNum = allNum;
    }

    public SectionTicketInfo() {
    }

    public TrainSection getSection() {
        return section;
    }

    public void setSection(TrainSection section) {
        this.section = section;
    }

    public int getPayNum() {
        return payNum;
    }

    public void setPayNum(int payNum) {
        this.payNum = payNum;
    }

    public int getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(int changeNum) {
        this.changeNum = changeNum;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "SectionTicketInfo{" +
                "section=" + section +
                ", payNum=" + payNum +
                ", changeNum=" + changeNum +
                ", trainName='" + trainName + '\'' +
                ", allNum=" + allNum +
                '}';
    }
}
