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
    private Integer replace;

    public SectionListBean(TrainSection section, String trainName, Integer replace) {
        this.section = section;
        this.trainName = trainName;
        this.replace = replace;
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

    public Integer getReplace() {
        return replace;
    }

    public void setReplace(Integer replace) {
        this.replace = replace;
    }

    @Override
    public String toString() {
        return "SectionListBean{" +
                "section=" + section +
                ", trainName='" + trainName + '\'' +
                ", replace=" + replace +
                '}';
    }
}
