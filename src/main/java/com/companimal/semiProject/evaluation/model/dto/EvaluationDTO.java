package com.companimal.semiProject.evaluation.model.dto;

import java.sql.Timestamp;

public class EvaluationDTO implements java.io.Serializable {

    private int evaNum;                 // 심사 번호
    private Timestamp evaDatetime;      // 심사 요청 일시
    private String evaSituation;        // 심사 상황
    private String reaRejection;        // 반려 사유

    public EvaluationDTO() {
    }

    public EvaluationDTO(int evaNum, Timestamp evaDatetime, String evaSituation, String reaRejection) {
        this.evaNum = evaNum;
        this.evaDatetime = evaDatetime;
        this.evaSituation = evaSituation;
        this.reaRejection = reaRejection;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    public Timestamp getEvaDatetime() {
        return evaDatetime;
    }

    public void setEvaDatetime(Timestamp evaDatetime) {
        this.evaDatetime = evaDatetime;
    }

    public String getEvaSituation() {
        return evaSituation;
    }

    public void setEvaSituation(String evaSituation) {
        this.evaSituation = evaSituation;
    }

    public String getReaRejection() {
        return reaRejection;
    }

    public void setReaRejection(String reaRejection) {
        this.reaRejection = reaRejection;
    }

    @Override
    public String toString() {
        return "EvaluationDTO{" +
                "evaNum=" + evaNum +
                ", evaDateTime=" + evaDatetime +
                ", evaSituation='" + evaSituation + '\'' +
                ", reaRejection='" + reaRejection + '\'' +
                '}';
    }
}
