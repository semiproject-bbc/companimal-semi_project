package com.companimal.semiProject.evaluation.model.dto;

import java.sql.Timestamp;

public class CalculationListDTO {
    private int proCode;
    private Timestamp calReqDatetime;
    private Timestamp calAppDatetime;
    private char calStatus;

    public CalculationListDTO() {
    }

    public CalculationListDTO(int proCode, Timestamp calReqDatetime, Timestamp calAppDatetime, char calStatus) {
        this.proCode = proCode;
        this.calReqDatetime = calReqDatetime;
        this.calAppDatetime = calAppDatetime;
        this.calStatus = calStatus;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public Timestamp getCalReqDatetime() {
        return calReqDatetime;
    }

    public void setCalReqDatetime(Timestamp calReqDatetime) {
        this.calReqDatetime = calReqDatetime;
    }

    public Timestamp getCalAppDatetime() {
        return calAppDatetime;
    }

    public void setCalAppDatetime(Timestamp calAppDatetime) {
        this.calAppDatetime = calAppDatetime;
    }

    public char getCalStatus() {
        return calStatus;
    }

    public void setCalStatus(char calStatus) {
        this.calStatus = calStatus;
    }

    @Override
    public String toString() {
        return "CalculationListDTO{" +
                "proCode=" + proCode +
                ", calReqDatetime=" + calReqDatetime +
                ", calAppDatetime=" + calAppDatetime +
                ", calStatus=" + calStatus +
                '}';
    }
}
