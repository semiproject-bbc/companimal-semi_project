package com.companimal.semiProject.project.model.dto;

public class ProjectImagePathDTO {

    private String proImgPath;      // 이미지 저장경로

    public ProjectImagePathDTO() {
    }

    public ProjectImagePathDTO(String proImgPath) {
        this.proImgPath = proImgPath;
    }

    public String getProImgPath() {
        return proImgPath;
    }

    public void setProImgPath(String proImgPath) {
        this.proImgPath = proImgPath;
    }

    @Override
    public String toString() {
        return "ProjectImagePathDTO{" +
                "proImgPath='" + proImgPath + '\'' +
                '}';
    }
}
