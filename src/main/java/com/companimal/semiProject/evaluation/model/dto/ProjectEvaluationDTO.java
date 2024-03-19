package com.companimal.semiProject.evaluation.model.dto;

import com.companimal.semiProject.project.model.dto.ProjectDTO;

import java.sql.Timestamp;

public class ProjectEvaluationDTO {

    /* 신고 테이블*/
    private int evaNum;                 // 심사 번호
    private Timestamp evaDateTime;      // 심사 요청 일시
    private String evaSituation;        // 심사 상황
    private String reaRejection;        // 반려 사유
    /* 프로젝트 테이블 */
    private int cateMain;               // 메인 카테고리
    private String proName;             // 프로젝트 제목
    private int proCode;                // 프로젝트 코드

    private ProjectDTO project;

    public ProjectEvaluationDTO() {
    }

    public ProjectEvaluationDTO(int evaNum, Timestamp evaDateTime, String evaSituation, String reaRejection, int cateMain, String proName, int proCode) {
        this.evaNum = evaNum;
        this.evaDateTime = evaDateTime;
        this.evaSituation = evaSituation;
        this.reaRejection = reaRejection;
        this.cateMain = cateMain;
        this.proName = proName;
        this.proCode = proCode;
    }

    public ProjectEvaluationDTO(int evaNum, Timestamp evaDateTime, String evaSituation, String reaRejection, int cateMain, String proName, int proCode, ProjectDTO project) {
        this.evaNum = evaNum;
        this.evaDateTime = evaDateTime;
        this.evaSituation = evaSituation;
        this.reaRejection = reaRejection;
        this.cateMain = cateMain;
        this.proName = proName;
        this.proCode = proCode;
        this.project = project;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    public Timestamp getEvaDateTime() {
        return evaDateTime;
    }

    public void setEvaDateTime(Timestamp evaDateTime) {
        this.evaDateTime = evaDateTime;
    }

    public int getCateMain() {
        return cateMain;
    }

    public void setCateMain(int cateMain) {
        this.cateMain = cateMain;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getEvaSituation() {
        return evaSituation;
    }

    public void setEvaSituation(String evaSituation) {
        this.evaSituation = evaSituation;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getReaRejection() {
        return reaRejection;
    }

    public void setReaRejection(String reaRejection) {
        this.reaRejection = reaRejection;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectEvaluationDTO{" +
                "evaNum=" + evaNum +
                ", evaDateTime=" + evaDateTime +
                ", evaSituation='" + evaSituation + '\'' +
                ", reaRejection='" + reaRejection + '\'' +
                ", cateMain=" + cateMain +
                ", proName='" + proName + '\'' +
                ", proCode=" + proCode +
                ", project=" + project +
                '}';
    }
}
