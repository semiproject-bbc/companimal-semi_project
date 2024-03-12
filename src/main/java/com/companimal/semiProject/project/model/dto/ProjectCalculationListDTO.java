package com.companimal.semiProject.project.model.dto;

import java.sql.Timestamp;

public class ProjectCalculationListDTO implements java.io.Serializable {

    private int proCode;                // 프로젝트 번호
    private Timestamp calReqDateTime;   // 최종 정산 요청일시
    private Timestamp calAppDateTime;   // 최종 정산 승인일시
    private String calStatus;           // 정산 상태

    public ProjectCalculationListDTO() {
    }

    public ProjectCalculationListDTO(int proCode, Timestamp calReqDateTime, Timestamp calAppDateTime, String calStatus) {
        this.proCode = proCode;
        this.calReqDateTime = calReqDateTime;
        this.calAppDateTime = calAppDateTime;
        this.calStatus = calStatus;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public Timestamp getCalReqDateTime() {
        return calReqDateTime;
    }

    public void setCalReqDateTime(Timestamp calReqDateTime) {
        this.calReqDateTime = calReqDateTime;
    }

    public Timestamp getCalAppDateTime() {
        return calAppDateTime;
    }

    public void setCalAppDateTime(Timestamp calAppDateTime) {
        this.calAppDateTime = calAppDateTime;
    }

    public String getCalStatus() {
        return calStatus;
    }

    public void setCalStatus(String calStatus) {
        this.calStatus = calStatus;
    }

    @Override
    public String toString() {
        return "ProjectCalculationListDTO{" +
                "proCode=" + proCode +
                ", calReqDateTime=" + calReqDateTime +
                ", calAppDateTime=" + calAppDateTime +
                ", calStatus='" + calStatus + '\'' +
                '}';
    }
}
