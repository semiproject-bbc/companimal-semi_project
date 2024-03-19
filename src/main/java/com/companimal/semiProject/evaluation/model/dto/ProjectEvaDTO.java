package com.companimal.semiProject.evaluation.model.dto;

import com.companimal.semiProject.project.model.dto.ProjectDTO;

public class ProjectEvaDTO {

    private int proCode;                // 프로젝트 코드
    private int evaNum;                 // 심사 번호

    private ProjectDTO project;
    private EvaluationDTO evaluation;

    public ProjectEvaDTO() {
    }

    public ProjectEvaDTO(int proCode, int evaNum) {
        this.proCode = proCode;
        this.evaNum = evaNum;
    }

    public ProjectEvaDTO(int proCode, int evaNum, ProjectDTO project) {
        this.proCode = proCode;
        this.evaNum = evaNum;
        this.project = project;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectEvaDTO{" +
                "proCode=" + proCode +
                ", evaNum=" + evaNum +
                ", project=" + project +
                '}';
    }
}
