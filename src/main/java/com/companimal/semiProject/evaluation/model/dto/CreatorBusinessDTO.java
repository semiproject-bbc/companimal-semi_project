package com.companimal.semiProject.evaluation.model.dto;

import java.util.Date;

public class CreatorBusinessDTO {

    private String memId;                // '크리에이터 아이디'
    private String busiNum;              // '사업자등록번호'
    private String busiName;             // '상호/법인명'
    private Date busiDate;               // '설립일'
    private String busiType;             // '기업형태'
    private String busiIndu;             // '업종'
    private String busiLoca;             // '소재지'
    private String busiSize;             // '기업규모'
    private String busiUrl;              // '홈페이지'
    private String authName;             // '담당자 이름'
    private String authNum;              // '담당자 전화번호'

    public CreatorBusinessDTO() {
    }

    public CreatorBusinessDTO(String memId, String busiNum, String busiName, Date busiDate, String busiType, String busiIndu, String busiLoca, String busiSize, String busiUrl, String authName, String authNum) {
        this.memId = memId;
        this.busiNum = busiNum;
        this.busiName = busiName;
        this.busiDate = busiDate;
        this.busiType = busiType;
        this.busiIndu = busiIndu;
        this.busiLoca = busiLoca;
        this.busiSize = busiSize;
        this.busiUrl = busiUrl;
        this.authName = authName;
        this.authNum = authNum;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getBusiNum() {
        return busiNum;
    }

    public void setBusiNum(String busiNum) {
        this.busiNum = busiNum;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public Date getBusiDate() {
        return busiDate;
    }

    public void setBusiDate(Date busiDate) {
        this.busiDate = busiDate;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getBusiIndu() {
        return busiIndu;
    }

    public void setBusiIndu(String busiIndu) {
        this.busiIndu = busiIndu;
    }

    public String getBusiLoca() {
        return busiLoca;
    }

    public void setBusiLoca(String busiLoca) {
        this.busiLoca = busiLoca;
    }

    public String getBusiSize() {
        return busiSize;
    }

    public void setBusiSize(String busiSize) {
        this.busiSize = busiSize;
    }

    public String getBusiUrl() {
        return busiUrl;
    }

    public void setBusiUrl(String busiUrl) {
        this.busiUrl = busiUrl;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthNum() {
        return authNum;
    }

    public void setAuthNum(String authNum) {
        this.authNum = authNum;
    }

    @Override
    public String toString() {
        return "CreatorBusinessDTO{" +
                "memId='" + memId + '\'' +
                ", busiNum='" + busiNum + '\'' +
                ", busiName='" + busiName + '\'' +
                ", busiDate=" + busiDate +
                ", busiType='" + busiType + '\'' +
                ", busiIndu='" + busiIndu + '\'' +
                ", busiLoca='" + busiLoca + '\'' +
                ", busiSize='" + busiSize + '\'' +
                ", busiUrl='" + busiUrl + '\'' +
                ", authName='" + authName + '\'' +
                ", authNum='" + authNum + '\'' +
                '}';
    }
}