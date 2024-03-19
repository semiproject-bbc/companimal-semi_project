package com.companimal.semiProject.member.model.dto;

import java.sql.Timestamp;

public class SupporterParticipatedProjectDTO {

    private String orderCode;
    private int finalPay;
    private Timestamp orderDate;
    private String rewName;
    private String rewOptName;
    private String rewOptVal;

    public SupporterParticipatedProjectDTO() {
    }

    public SupporterParticipatedProjectDTO(String orderCode, int finalPay, Timestamp orderDate, String rewName, String rewOptName, String rewOptVal) {
        this.orderCode = orderCode;
        this.finalPay = finalPay;
        this.orderDate = orderDate;
        this.rewName = rewName;
        this.rewOptName = rewOptName;
        this.rewOptVal = rewOptVal;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(int finalPay) {
        this.finalPay = finalPay;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getRewName() {
        return rewName;
    }

    public void setRewName(String rewName) {
        this.rewName = rewName;
    }

    public String getRewOptName() {
        return rewOptName;
    }

    public void setRewOptName(String rewOptName) {
        this.rewOptName = rewOptName;
    }

    public String getRewOptVal() {
        return rewOptVal;
    }

    public void setRewOptVal(String rewOptVal) {
        this.rewOptVal = rewOptVal;
    }

    @Override
    public String toString() {
        return "SupporterParticipatedProjectDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", finalPay=" + finalPay +
                ", orderDate=" + orderDate +
                ", rewName='" + rewName + '\'' +
                ", rewOptName='" + rewOptName + '\'' +
                ", rewOptVal='" + rewOptVal + '\'' +
                '}';
    }
}
