package com.companimal.semiProject.evaluation.model.dto;

import java.sql.Timestamp;

public class EvaluationDTO implements java.io.Serializable {

    private int evaNum;                 // 심사 번호
    private Timestamp evaDateTime;      // 심사 요청 일시
    private String evaSituation;        // 심사 상황
    private String reaRejection;        // 반려 사유

    public EvaluationDTO() {
    }

    public EvaluationDTO(int evaNum, Timestamp evaDateTime, String evaSituation, String reaRejection) {
        this.evaNum = evaNum;
        this.evaDateTime = evaDateTime;
        this.evaSituation = evaSituation;
        this.reaRejection = reaRejection;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    public Timestamp getEvaDateTime() {
        return evaDateTime;
    }

    public void setEvaDateTime(Timestamp evaDateTime) {
        this.evaDateTime = evaDateTime;
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
                ", evaDateTime=" + evaDateTime +
                ", evaSituation='" + evaSituation + '\'' +
                ", reaRejection='" + reaRejection + '\'' +
                '}';
    }
}
