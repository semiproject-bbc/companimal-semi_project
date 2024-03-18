package com.companimal.semiProject.order.model.dto;

import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;

import java.util.List;


public class GetOrderDetailsInfoDTO {

    private int proCode;                            // 프로젝트 코드
    private int orderAmount;                        // 총 금액
    private String proName;                         // 프로젝트 이름

    public GetOrderDetailsInfoDTO() {
    }

    public GetOrderDetailsInfoDTO(int proCode, int orderAmount, String proName) {
        this.proCode = proCode;
        this.orderAmount = orderAmount;
        this.proName = proName;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "GetOrderDetailsInfoDTO{" +
                "proCode=" + proCode +
                ", orderAmount=" + orderAmount +
                ", proName='" + proName + '\'' +
                '}';
    }
}
