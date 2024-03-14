package com.companimal.semiProject.order.model.dto;

public class OrderRewardInfoDTO {

    private int rewOptNum;
    private String rewOptName;
    private String rewOptVal;
    private int rewNum;
    private String rewName;
    private int rewSf;
    private int proCode;
    private String proName;

    public OrderRewardInfoDTO() {
    }

    public OrderRewardInfoDTO(int rewOptNum, String rewOptName, String rewOptVal, int rewNum, String rewName, int rewSf, int proCode, String proName) {
        this.rewOptNum = rewOptNum;
        this.rewOptName = rewOptName;
        this.rewOptVal = rewOptVal;
        this.rewNum = rewNum;
        this.rewName = rewName;
        this.rewSf = rewSf;
        this.proCode = proCode;
        this.proName = proName;
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

    public int getRewNum() {
        return rewNum;
    }

    public void setRewNum(int rewNum) {
        this.rewNum = rewNum;
    }

    public String getRewName() {
        return rewName;
    }

    public void setRewName(String rewName) {
        this.rewName = rewName;
    }

    public int getRewSf() {
        return rewSf;
    }

    public void setRewSf(int rewSf) {
        this.rewSf = rewSf;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "OrderRewardInfoDTO{" +
                "rewOptNum=" + rewOptNum +
                ", rewOptName='" + rewOptName + '\'' +
                ", rewOptVal='" + rewOptVal + '\'' +
                ", rewNum=" + rewNum +
                ", rewName='" + rewName + '\'' +
                ", rewSf=" + rewSf +
                ", proCode=" + proCode +
                ", proName='" + proName + '\'' +
                '}';
    }
}
