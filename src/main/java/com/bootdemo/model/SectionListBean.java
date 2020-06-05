package com.bootdemo.model;

import com.bootdemo.domain.TrainSection;

/**
 * @Author: ASUS
 * @Date: 2020/6/4 22:37
 * @Version: 1.0
 */
public class SectionListBean {
    private TrainSection section;
    private String trainName;

    public SectionListBean(TrainSection section, String trainName) {
        this.section = section;
        this.trainName = trainName;
    }

    public TrainSection getSection() {
        return section;
    }

    public void setSection(TrainSection section) {
        this.section = section;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public String toString() {
        return "SectionListBean{" +
                "section=" + section +
                ", trainName='" + trainName + '\'' +
                '}';
    }
}
