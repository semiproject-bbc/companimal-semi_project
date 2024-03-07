package com.companimal.semiProject.evaluation.model.dto;

public class EvaluationProjectDTO implements java.io.Serializable {

    private int proCode;    // 프로젝트 번호
    private int evaNum;     // 심사 번호

    public EvaluationProjectDTO() {
    }

    public EvaluationProjectDTO(int proCode, int evaNum) {
        this.proCode = proCode;
        this.evaNum = evaNum;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    @Override
    public String toString() {
        return "EvaluationProjectDTO{" +
                "proCode=" + proCode +
                ", evaNum=" + evaNum +
                '}';
    }
}
