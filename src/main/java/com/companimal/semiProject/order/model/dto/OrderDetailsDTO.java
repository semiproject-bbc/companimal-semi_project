package com.companimal.semiProject.order.model.dto;

public class OrderDetailsDTO {

    private int rewOptNum;      // 제한수량
    private String rewOptName;  // 리워드 옵션명
    private String rewOptVal;   // 옵션값
    private int rewNum;         // 리워드 번호
    private String rewName;     // 리워드명
    private int rewSf;          // 배송비
    private int proCode;        // 프로젝트 코드
    private String proName;     // 프로젝트명

    private int couAmount;      // 쿠폰 금액
    private String couCode;     // 쿠폰 코드
    private String couName;     // 쿠폰명
    private String memId;       // 회원 ID
    private String memName;     // 이름
    private String memPhone;    // 전화번호
    private String memEmail;    // 이메일

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(int rewOptNum, String rewOptName, String rewOptVal, int rewNum, String rewName, int rewSf, int proCode, String proName, int couAmount, String couCode, String couName, String memId, String memName, String memPhone, String memEmail) {
        this.rewOptNum = rewOptNum;
        this.rewOptName = rewOptName;
        this.rewOptVal = rewOptVal;
        this.rewNum = rewNum;
        this.rewName = rewName;
        this.rewSf = rewSf;
        this.proCode = proCode;
        this.proName = proName;
        this.couAmount = couAmount;
        this.couCode = couCode;
        this.couName = couName;
        this.memId = memId;
        this.memName = memName;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
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
        return "OrderDetailsDTO{" +
                "rewOptNum=" + rewOptNum +
                ", rewOptName='" + rewOptName + '\'' +
                ", rewOptVal='" + rewOptVal + '\'' +
                ", rewNum=" + rewNum +
                ", rewName='" + rewName + '\'' +
                ", rewSf=" + rewSf +
                ", proCode=" + proCode +
                ", proName='" + proName + '\'' +
                ", couAmount=" + couAmount +
                ", couCode='" + couCode + '\'' +
                ", couName='" + couName + '\'' +
                ", memId='" + memId + '\'' +
                ", memName='" + memName + '\'' +
                ", memPhone=" + memPhone +
                ", memEmail='" + memEmail + '\'' +
                '}';
    }
}
