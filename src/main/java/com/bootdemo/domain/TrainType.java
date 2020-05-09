package com.bootdemo.domain;

import java.util.Objects;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class TrainType {
    private int trainId;
    private int carriageNum;
    private int allPassengerNum;
    private String wayStation;

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getCarriageNum() {
        return carriageNum;
    }

    public void setCarriageNum(int carriageNum) {
        this.carriageNum = carriageNum;
    }

    public int getAllPassengerNum() {
        return allPassengerNum;
    }

    public void setAllPassengerNum(int allPassengerNum) {
        this.allPassengerNum = allPassengerNum;
    }

    public String getWayStation() {
        return wayStation;
    }

    public void setWayStation(String wayStation) {
        this.wayStation = wayStation;
    }


    @Override
    public String toString() {
        return "TrainType{" +
                "trainId=" + trainId +
                ", carriageNum=" + carriageNum +
                ", allPassengerNum=" + allPassengerNum +
                ", wayStation='" + wayStation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainType trainType = (TrainType) o;
        return trainId == trainType.trainId &&
                carriageNum == trainType.carriageNum &&
                allPassengerNum == trainType.allPassengerNum &&
                Objects.equals(wayStation, trainType.wayStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, carriageNum, allPassengerNum, wayStation);
    }
}
