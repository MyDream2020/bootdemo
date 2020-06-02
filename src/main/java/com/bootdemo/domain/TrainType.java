package com.bootdemo.domain;


/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class TrainType {
    private int trainId;
    private int carriageNum;
    private int allPassengerNum;
    private String trainName;
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

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public String toString() {
        return "TrainType{" +
                "trainId=" + trainId +
                ", carriageNum=" + carriageNum +
                ", allPassengerNum=" + allPassengerNum +
                ", trainName='" + trainName + '\'' +
                ", wayStation='" + wayStation + '\'' +
                '}';
    }
}
