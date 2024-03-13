package com.companimal.semiProject.order.model.dto;

import java.sql.Timestamp;

public class CouponDTO {

    private String couCode;
    private String couName;
    private int couAmount;
    private Timestamp couDateTime;
    private String couYn;
    private String memId;

    public CouponDTO() {
    }

    public CouponDTO(String couCode, String couName, int couAmount, Timestamp couDateTime, String couYn, String memId) {
        this.couCode = couCode;
        this.couName = couName;
        this.couAmount = couAmount;
        this.couDateTime = couDateTime;
        this.couYn = couYn;
        this.memId = memId;
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

    public int getCouAmount() {
        return couAmount;
    }

    public void setCouAmount(int couAmount) {
        this.couAmount = couAmount;
    }

    public Timestamp getCouDateTime() {
        return couDateTime;
    }

    public void setCouDateTime(Timestamp couDateTime) {
        this.couDateTime = couDateTime;
    }

    public String getCouYn() {
        return couYn;
    }

    public void setCouYn(String couYn) {
        this.couYn = couYn;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "CouponDTO{" +
                "couCode='" + couCode + '\'' +
                ", couName='" + couName + '\'' +
                ", couAmount=" + couAmount +
                ", couDateTime=" + couDateTime +
                ", couYn='" + couYn + '\'' +
                ", memId='" + memId + '\'' +
                '}';
    }
}
