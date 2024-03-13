package com.companimal.semiProject.evaluation.model.dto;

public class CreatorFileDTO {
    private int creEvaNum;         // '파일 번호'
    private String memberId;       // '크리에이터 아이디'
    private String creFilePath;    // '파일 저장경로'
    private String creFileName;    // '파일 저장명'
    private String creFileOriName; // '원본 파일명'

    public CreatorFileDTO() {
    }

    public CreatorFileDTO(int creEvaNum, String memberId, String creFilePath, String creFileName, String creFileOriName) {
        this.creEvaNum = creEvaNum;
        this.memberId = memberId;
        this.creFilePath = creFilePath;
        this.creFileName = creFileName;
        this.creFileOriName = creFileOriName;
    }

    public int getCreEvaNum() {
        return creEvaNum;
    }

    public void setCreEvaNum(int creEvaNum) {
        this.creEvaNum = creEvaNum;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCreFilePath() {
        return creFilePath;
    }

    public void setCreFilePath(String creFilePath) {
        this.creFilePath = creFilePath;
    }

    public String getCreFileName() {
        return creFileName;
    }

    public void setCreFileName(String creFileName) {
        this.creFileName = creFileName;
    }

    public String getCreFileOriName() {
        return creFileOriName;
    }

    public void setCreFileOriName(String creFileOriName) {
        this.creFileOriName = creFileOriName;
    }

    @Override
    public String toString() {
        return "CreatorFileDTO{" +
                "creEvaNum=" + creEvaNum +
                ", memberId='" + memberId + '\'' +
                ", creFilePath='" + creFilePath + '\'' +
                ", creFileName='" + creFileName + '\'' +
                ", creFileOriName='" + creFileOriName + '\'' +
                '}';
    }
}
