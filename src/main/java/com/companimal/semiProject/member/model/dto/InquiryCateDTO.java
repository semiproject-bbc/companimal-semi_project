package com.companimal.semiProject.member.model.dto;

public class InquiryCateDTO {

    private int inqCateCode;
    private String inqCateName;

    public InquiryCateDTO() {
    }

    public InquiryCateDTO(int inqCateCode, String inqCateName) {
        this.inqCateCode = inqCateCode;
        this.inqCateName = inqCateName;
    }

    public int getInqCateCode() {
        return inqCateCode;
    }

    public void setInqCateCode(int inqCateCode) {
        this.inqCateCode = inqCateCode;
    }

    public String getInqCateName() {
        return inqCateName;
    }

    public void setInqCateName(String inqCateName) {
        this.inqCateName = inqCateName;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inqCateCode=" + inqCateCode +
                ", inqCateName='" + inqCateName + '\'' +
                '}';
    }
}
