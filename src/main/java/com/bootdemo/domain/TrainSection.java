package com.bootdemo.domain;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class TrainSection {
    private int sectionId;
    private int trainId;
    private String startSection;
    private String endSection;
    private Timestamp startTime;
    private Timestamp endTime;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getStartSection() {
        return startSection;
    }

    public void setStartSection(String startSection) {
        this.startSection = startSection;
    }

    public String getEndSection() {
        return endSection;
    }

    public void setEndSection(String endSection) {
        this.endSection = endSection;
    }

    public String getStartTime() {
        String time = startTime.toString();
        return time.substring(0,time.indexOf('.'));
    }

    public Timestamp getDateStartTime(){
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        String time = endTime.toString();
        return time.substring(0,time.indexOf('.'));
    }

    public Timestamp getDateEndTime(){
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TrainSection{" +
                "sectionId=" + sectionId +
                ", trainId=" + trainId +
                ", startSection='" + startSection + '\'' +
                ", endSection='" + endSection + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainSection that = (TrainSection) o;
        return sectionId == that.sectionId &&
                trainId == that.trainId &&
                Objects.equals(startSection, that.startSection) &&
                Objects.equals(endSection, that.endSection) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionId, trainId, startSection, endSection, startTime, endTime);
    }
}
