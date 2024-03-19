package com.companimal.semiProject.project.model.dto;

public class ProjectCateSubDTO {

    private int proCateCode;            // 프로젝트 카테고리코드
    private String proCateSubName;         // 프로젝트 카테고리 서브명
    private String proCateType;         // 프로젝트 카테고리분류

    public ProjectCateSubDTO() {
    }

    public ProjectCateSubDTO(int proCateCode, String proCateSubName, String proCateType) {
        this.proCateCode = proCateCode;
        this.proCateSubName = proCateSubName;
        this.proCateType = proCateType;
    }

    public int getProCateCode() {
        return proCateCode;
    }

    public void setProCateCode(int proCateCode) {
        this.proCateCode = proCateCode;
    }

    public String getProCateSubName() {
        return proCateSubName;
    }

    public void setProCateSubName(String proCateSubName) {
        this.proCateSubName = proCateSubName;
    }

    public String getProCateType() {
        return proCateType;
    }

    public void setProCateType(String proCateType) {
        this.proCateType = proCateType;
    }

    @Override
    public String toString() {
        return "ProjectCateSubDTO{" +
                "proCateCode=" + proCateCode +
                ", proCateSubName='" + proCateSubName + '\'' +
                ", proCateType='" + proCateType + '\'' +
                '}';
    }
}
