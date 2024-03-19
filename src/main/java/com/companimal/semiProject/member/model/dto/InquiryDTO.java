package com.companimal.semiProject.member.model.dto;

import java.sql.Timestamp;

public class InquiryDTO {

    private String memId;
    private int proCode;
    private String inqContent;
    private Timestamp inqDateTime;
    private String inqAnswer;
    private int inqCateCode;

    public InquiryDTO() {
    }

    public InquiryDTO(String memId, int proCode, String inqContent, Timestamp inqDateTime, String inqAnswer, int inqCateCode) {
        this.memId = memId;
        this.proCode = proCode;
        this.inqContent = inqContent;
        this.inqDateTime = inqDateTime;
        this.inqAnswer = inqAnswer;
        this.inqCateCode = inqCateCode;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getInqContent() {
        return inqContent;
    }

    public void setInqContent(String inqContent) {
        this.inqContent = inqContent;
    }

    public Timestamp getInqDateTime() {
        return inqDateTime;
    }

    public void setInqDateTime(Timestamp inqDateTime) {
        this.inqDateTime = inqDateTime;
    }

    public String getInqAnswer() {
        return inqAnswer;
    }

    public void setInqAnswer(String inqAnswer) {
        this.inqAnswer = inqAnswer;
    }

    public int getInqCateCode() {
        return inqCateCode;
    }

    public void setInqCateCode(int inqCateCode) {
        this.inqCateCode = inqCateCode;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "memId='" + memId + '\'' +
                ", proCode=" + proCode +
                ", inqContent='" + inqContent + '\'' +
                ", inqDateTime=" + inqDateTime +
                ", inqAnswer='" + inqAnswer + '\'' +
                ", inqCateCode=" + inqCateCode +
                '}';
    }
}
