package com.companimal.semiProject.project.model.dto;

public class ProjectImageDTO implements java.io.Serializable {

    private int proImgNum;          // 이미지 번호
    private int proCode;            // 프로젝트 코드
    private String proImgPath;      // 이미지 저장경로
    private String proImgName;      // 이미지 저장명
    private String proImgOriName;   // 원본 이미지명

    public ProjectImageDTO() {
    }

    public ProjectImageDTO(int proImgNum, int proCode, String proImgPath, String proImgName, String proImgOriName) {
        this.proImgNum = proImgNum;
        this.proCode = proCode;
        this.proImgPath = proImgPath;
        this.proImgName = proImgName;
        this.proImgOriName = proImgOriName;
    }

    public int getProImgNum() {
        return proImgNum;
    }

    public void setProImgNum(int proImgNum) {
        this.proImgNum = proImgNum;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getProImgPath() {
        return proImgPath;
    }

    public void setProImgPath(String proImgPath) {
        this.proImgPath = proImgPath;
    }

    public String getProImgName() {
        return proImgName;
    }

    public void setProImgName(String proImgName) {
        this.proImgName = proImgName;
    }

    public String getProImgOriName() {
        return proImgOriName;
    }

    public void setProImgOriName(String proImgOriName) {
        this.proImgOriName = proImgOriName;
    }

    @Override
    public String toString() {
        return "ProjectImageDTO{" +
                "proImgNum=" + proImgNum +
                ", proCode=" + proCode +
                ", proImgPath='" + proImgPath + '\'' +
                ", proImgName='" + proImgName + '\'' +
                ", proImgOriName='" + proImgOriName + '\'' +
                '}';
    }
}
