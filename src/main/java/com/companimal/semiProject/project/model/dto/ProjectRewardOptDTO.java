package com.companimal.semiProject.project.model.dto;

public class ProjectRewardOptDTO implements java.io.Serializable {

    private String rewOptCode;      // 리워드 옵션 코드
    private String rewCode;         // 리워드 코드
    private int rewOptNum;          // 리워드 옵션 번호
    private String rewOptName;      // 옵션명 o
    private String rewOptVal;       // 옵션값 o
    private String rewOptLimit;        // 제한 수량
    private String rewAmount;          // 리워드 금액 o

    public ProjectRewardOptDTO() {
    }

    public ProjectRewardOptDTO(String rewOptCode, String rewCode, int rewOptNum, String rewOptName, String rewOptVal, String rewOptLimit, String rewAmount) {
        this.rewOptCode = rewOptCode;
        this.rewCode = rewCode;
        this.rewOptNum = rewOptNum;
        this.rewOptName = rewOptName;
        this.rewOptVal = rewOptVal;
        this.rewOptLimit = rewOptLimit;
        this.rewAmount = rewAmount;
    }

    public String getRewOptCode() {
        return rewOptCode;
    }

    public void setRewOptCode(String rewOptCode) {
        this.rewOptCode = rewOptCode;
    }

    public String getRewCode() {
        return rewCode;
    }

    public void setRewCode(String rewCode) {
        this.rewCode = rewCode;
    }

    public int getRewOptNum() {
        return rewOptNum;
    }

    public void setRewOptNum(int rewOptNum) {
        this.rewOptNum = rewOptNum;
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

    public String getRewOptLimit() {
        return rewOptLimit;
    }

    public void setRewOptLimit(String rewOptLimit) {
        this.rewOptLimit = rewOptLimit;
    }

    public String getRewAmount() {
        return rewAmount;
    }

    public void setRewAmount(String rewAmount) {
        this.rewAmount = rewAmount;
    }

    @Override
    public String toString() {
        return "ProjectRewardOptDTO{" +
                "rewOptCode='" + rewOptCode + '\'' +
                ", rewCode='" + rewCode + '\'' +
                ", rewOptNum=" + rewOptNum +
                ", rewOptName='" + rewOptName + '\'' +
                ", rewOptVal='" + rewOptVal + '\'' +
                ", rewOptLimit=" + rewOptLimit +
                ", rewAmount=" + rewAmount +
                '}';
    }
}
