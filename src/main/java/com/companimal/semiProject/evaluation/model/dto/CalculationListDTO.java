package com.companimal.semiProject.evaluation.model.dto;

import com.companimal.semiProject.project.model.dto.ProjectDTO;

import java.sql.Timestamp;
import java.util.List;

public class CalculationListDTO {
    private int proCode;
    private Timestamp calReqDatetime;
    private Timestamp calAppDatetime;
    private char calStatus;
    private List<ProjectDTO> project;

    public CalculationListDTO() {
    }

    public CalculationListDTO(int proCode, Timestamp calReqDatetime, Timestamp calAppDatetime, char calStatus) {
        this.proCode = proCode;
        this.calReqDatetime = calReqDatetime;
        this.calAppDatetime = calAppDatetime;
        this.calStatus = calStatus;
    }

    public CalculationListDTO(int proCode, Timestamp calReqDatetime, Timestamp calAppDatetime, char calStatus, List<ProjectDTO> project) {
        this.proCode = proCode;
        this.calReqDatetime = calReqDatetime;
        this.calAppDatetime = calAppDatetime;
        this.calStatus = calStatus;
        this.project = project;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public Timestamp getCalReqDatetime() {
        return calReqDatetime;
    }

    public void setCalReqDatetime(Timestamp calReqDatetime) {
        this.calReqDatetime = calReqDatetime;
    }

    public Timestamp getCalAppDatetime() {
        return calAppDatetime;
    }

    public void setCalAppDatetime(Timestamp calAppDatetime) {
        this.calAppDatetime = calAppDatetime;
    }

    public char getCalStatus() {
        return calStatus;
    }

    public void setCalStatus(char calStatus) {
        this.calStatus = calStatus;
    }

    public List<ProjectDTO> getProject() {
        return project;
    }

    public void setProject(List<ProjectDTO> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "CalculationListDTO{" +
                "proCode=" + proCode +
                ", calReqDatetime=" + calReqDatetime +
                ", calAppDatetime=" + calAppDatetime +
                ", calStatus=" + calStatus +
                ", project=" + project +
                '}';
    }
}
