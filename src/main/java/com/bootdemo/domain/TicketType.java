package com.bootdemo.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:54
 * @Version: 1.0
 */
public class TicketType {
    private int typeId;
    private int sectionId;
    private String seatGrade;
    private BigDecimal price;
    private Integer compartmentNum;
    private Integer allSeatNum;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSeatGrade() {
        return seatGrade;
    }

    public void setSeatGrade(String seatGrade) {
        this.seatGrade = seatGrade;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCompartmentNum() {
        return compartmentNum;
    }

    public void setCompartmentNum(Integer compartmentNum) {
        this.compartmentNum = compartmentNum;
    }

    public Integer getAllSeatNum() {
        return allSeatNum;
    }

    public void setAllSeatNum(Integer allSeatNum) {
        this.allSeatNum = allSeatNum;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "typeId=" + typeId +
                ", sectionId=" + sectionId +
                ", seatGrade='" + seatGrade + '\'' +
                ", price=" + price +
                ", compartmentNum=" + compartmentNum +
                ", allSeatNum=" + allSeatNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketType that = (TicketType) o;
        return typeId == that.typeId &&
                sectionId == that.sectionId &&
                Objects.equals(seatGrade, that.seatGrade) &&
                Objects.equals(price, that.price) &&
                Objects.equals(compartmentNum, that.compartmentNum) &&
                Objects.equals(allSeatNum, that.allSeatNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, sectionId, seatGrade, price, compartmentNum, allSeatNum);
    }
}
