package com.companimal.semiProject.project.model.dto;

public class ProjectCateDTO implements java.io.Serializable {

    private int proCateCode;            // 프로젝트 카테고리코드
    private String proCateName;         // 프로젝트 카테고리명
    private String proCateType;         // 프로젝트 카테고리분류

    public ProjectCateDTO() {
    }

    public ProjectCateDTO(int proCateCode, String proCateName, String proCateType) {
        this.proCateCode = proCateCode;
        this.proCateName = proCateName;
        this.proCateType = proCateType;
    }

    public int getProCateCode() {
        return proCateCode;
    }

    public void setProCateCode(int proCateCode) {
        this.proCateCode = proCateCode;
    }

    public String getProCateName() {
        return proCateName;
    }

    public void setProCateName(String proCateName) {
        this.proCateName = proCateName;
    }

    public String getProCateType() {
        return proCateType;
    }

    public void setProCateType(String proCateType) {
        this.proCateType = proCateType;
    }

    @Override
    public String toString() {
        return "ProjectCateDTO{" +
                "proCateCode=" + proCateCode +
                ", proCateName='" + proCateName + '\'' +
                ", proCateType='" + proCateType + '\'' +
                '}';
    }
}
