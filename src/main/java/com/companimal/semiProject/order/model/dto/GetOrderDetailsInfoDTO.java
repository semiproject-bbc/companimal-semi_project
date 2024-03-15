package com.companimal.semiProject.order.model.dto;

import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;

import java.util.List;


public class GetOrderDetailsInfoDTO {

    private int proCode;                            // 프로젝트 코드
    private int noOfOrder;                          // 수량
    private int orderAmount;                        // 총 금액
    private String proName;
    List<ProjectRewardDTO> projectRewardDTOList;

    public GetOrderDetailsInfoDTO() {
    }

    public GetOrderDetailsInfoDTO(int noOfOrder, int orderAmount, int proCode, String proName, List<ProjectRewardDTO> projectRewardDTOList) {
        this.noOfOrder = noOfOrder;
        this.orderAmount = orderAmount;
        this.proCode = proCode;
        this.proName = proName;
        this.projectRewardDTOList = projectRewardDTOList;
    }

    public int getNoOfOrder() {
        return noOfOrder;
    }

    public void setNoOfOrder(int noOfOrder) {
        this.noOfOrder = noOfOrder;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public List<ProjectRewardDTO> getProjectRewardDTOList() {
        return projectRewardDTOList;
    }

    public void setProjectRewardDTOList(List<ProjectRewardDTO> projectRewardDTOList) {
        this.projectRewardDTOList = projectRewardDTOList;
    }

    @Override
    public String toString() {
        return "GetOrderDetailsInfoDTO{" +
                "noOfOrder=" + noOfOrder +
                ", orderAmount=" + orderAmount +
                ", proCode=" + proCode +
                ", proName='" + proName + '\'' +
                ", projectRewardDTOList=" + projectRewardDTOList +
                '}';
    }
}
