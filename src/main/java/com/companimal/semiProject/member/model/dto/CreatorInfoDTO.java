package com.companimal.semiProject.member.model.dto;

public class CreatorInfoDTO {

    private String memId;               // '크리에이터 아이디'
    private String creInqPhone;         // '문의 전화번호'
    private String creInqEmail;         // '문의 이메일'
    private String creImgName;          // '크리에이터 이미지 저장명'
    private String creImgPath;          // '크리에이터 이미지 저장경로'
    private String creImgOriName;       // '크리에이터 이미지 원본 이미지명'
    private String bankName;            // '은행명'
    private String accountNo;           // '계좌 번호'
    private String depositorName;       // '예금주명'

    public CreatorInfoDTO(String memId) {
        this.memId = memId;
    }

    public CreatorInfoDTO(String memId, String creInqPhone, String creInqEmail, String creImgName, String creImgPath, String creImgOriName, String bankName, String accountNo, String depositorName) {
        this.memId = memId;
        this.creInqPhone = creInqPhone;
        this.creInqEmail = creInqEmail;
        this.creImgName = creImgName;
        this.creImgPath = creImgPath;
        this.creImgOriName = creImgOriName;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.depositorName = depositorName;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getCreInqPhone() {
        return creInqPhone;
    }

    public void setCreInqPhone(String creInqPhone) {
        this.creInqPhone = creInqPhone;
    }

    public String getCreInqEmail() {
        return creInqEmail;
    }

    public void setCreInqEmail(String creInqEmail) {
        this.creInqEmail = creInqEmail;
    }

    public String getCreImgName() {
        return creImgName;
    }

    public void setCreImgName(String creImgName) {
        this.creImgName = creImgName;
    }

    public String getCreImgPath() {
        return creImgPath;
    }

    public void setCreImgPath(String creImgPath) {
        this.creImgPath = creImgPath;
    }

    public String getCreImgOriName() {
        return creImgOriName;
    }

    public void setCreImgOriName(String creImgOriName) {
        this.creImgOriName = creImgOriName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    @Override
    public String toString() {
        return "CreatorInfoDTO{" +
                "memId='" + memId + '\'' +
                ", creInqPhone='" + creInqPhone + '\'' +
                ", creInqEmail='" + creInqEmail + '\'' +
                ", creImgName='" + creImgName + '\'' +
                ", creImgPath='" + creImgPath + '\'' +
                ", creImgOriName='" + creImgOriName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", depositorName='" + depositorName + '\'' +
                '}';
    }
}
