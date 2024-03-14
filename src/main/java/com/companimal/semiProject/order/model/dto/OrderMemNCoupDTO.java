package com.companimal.semiProject.order.model.dto;

public class OrderMemNCoupDTO {

    private int couAmount;
    private String couCode;
    private String couName;
    private String memId;
    private String memName;
    private String memPhone;
    private String memEmail;

    public OrderMemNCoupDTO() {
    }

    public OrderMemNCoupDTO(int couAmount, String couCode, String couName, String memId, String memName, String memPhone, String memEmail) {
        this.couAmount = couAmount;
        this.couCode = couCode;
        this.couName = couName;
        this.memId = memId;
        this.memName = memName;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
    }

    public int getCouAmount() {
        return couAmount;
    }

    public void setCouAmount(int couAmount) {
        this.couAmount = couAmount;
    }

    public String getCouCode() {
        return couCode;
    }

    public void setCouCode(String couCode) {
        this.couCode = couCode;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    @Override
    public String toString() {
        return "OrderMemNCoupDTO{" +
                "couAmount=" + couAmount +
                ", couCode='" + couCode + '\'' +
                ", couName='" + couName + '\'' +
                ", memId='" + memId + '\'' +
                ", memName='" + memName + '\'' +
                ", memPhone=" + memPhone +
                ", memEmail='" + memEmail + '\'' +
                '}';
    }
}
