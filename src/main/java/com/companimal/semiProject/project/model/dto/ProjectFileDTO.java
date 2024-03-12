package com.companimal.semiProject.project.model.dto;

public class ProjectFileDTO implements java.io.Serializable {

    private int proFileNum;         // 파일 번호
    private int proCode;            // 프로젝트 코드
    private String proFilePath;     // 파일 저장경로
    private String proFileName;     // 파일 저장명
    private String proFileOriName;  // 원본 파일명

    public ProjectFileDTO() {
    }

    public ProjectFileDTO(int proFileNum, int proCode, String proFilePath, String proFileName, String proFileOriName) {
        this.proFileNum = proFileNum;
        this.proCode = proCode;
        this.proFilePath = proFilePath;
        this.proFileName = proFileName;
        this.proFileOriName = proFileOriName;
    }

    public int getProFileNum() {
        return proFileNum;
    }

    public void setProFileNum(int proFileNum) {
        this.proFileNum = proFileNum;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getProFilePath() {
        return proFilePath;
    }

    public void setProFilePath(String proFilePath) {
        this.proFilePath = proFilePath;
    }

    public String getProFileName() {
        return proFileName;
    }

    public void setProFileName(String proFileName) {
        this.proFileName = proFileName;
    }

    public String getProFileOriName() {
        return proFileOriName;
    }

    public void setProFileOriName(String proFileOriName) {
        this.proFileOriName = proFileOriName;
    }

    @Override
    public String toString() {
        return "ProjectFileDTO{" +
                "proFileNum=" + proFileNum +
                ", proCode=" + proCode +
                ", proFilePath='" + proFilePath + '\'' +
                ", proFileName='" + proFileName + '\'' +
                ", proFileOriName='" + proFileOriName + '\'' +
                '}';
    }
}
