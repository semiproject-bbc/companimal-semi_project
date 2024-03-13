package com.companimal.semiProject.evaluation.model.dto;

public class CreatorEvaDTO implements java.io.Serializable {

    private String memId;   // 크리에이터 아이디
    private int evaNum;     // 심사 번호

    public CreatorEvaDTO() {
    }

    public CreatorEvaDTO(String memId, int evaNum) {
        this.memId = memId;
        this.evaNum = evaNum;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    @Override
    public String toString() {
        return "EvaluationCreaterDTO{" +
                "memId='" + memId + '\'' +
                ", evaNum=" + evaNum +
                '}';
    }
}
