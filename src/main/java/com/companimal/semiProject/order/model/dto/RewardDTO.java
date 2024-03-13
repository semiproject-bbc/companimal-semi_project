package com.companimal.semiProject.order.model.dto;

import java.util.List;

public class RewardDTO implements java.io.Serializable {

    private String rewCode;         // 리워드 코드
    private int rewNum;             // 리워드 번호
    private int proCode;            // 프로젝트 코드
    private String rewName;         // 리워드명
    private String rewExplain;      // 리워드 설명
    private int rewSf;              // 배송비
    List<RewardOptDTO> rewardOptDTOList;

    public RewardDTO() {
    }

    public RewardDTO(String rewCode, int rewNum, int proCode, String rewName, String rewExplain, int rewSf, List<RewardOptDTO> rewardOptDTOList) {
        this.rewCode = rewCode;
        this.rewNum = rewNum;
        this.proCode = proCode;
        this.rewName = rewName;
        this.rewExplain = rewExplain;
        this.rewSf = rewSf;
        this.rewardOptDTOList = rewardOptDTOList;
    }

    public String getRewCode() {
        return rewCode;
    }

    public void setRewCode(String rewCode) {
        this.rewCode = rewCode;
    }

    public int getRewNum() {
        return rewNum;
    }

    public void setRewNum(int rewNum) {
        this.rewNum = rewNum;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getRewName() {
        return rewName;
    }

    public void setRewName(String rewName) {
        this.rewName = rewName;
    }

    public String getRewExplain() {
        return rewExplain;
    }

    public void setRewExplain(String rewExplain) {
        this.rewExplain = rewExplain;
    }

    public int getRewSf() {
        return rewSf;
    }

    public void setRewSf(int rewSf) {
        this.rewSf = rewSf;
    }

    public List<RewardOptDTO> getRewardOptDTOList() {
        return rewardOptDTOList;
    }

    public void setRewardOptDTOList(List<RewardOptDTO> rewardOptDTOList) {
        this.rewardOptDTOList = rewardOptDTOList;
    }

    @Override
    public String toString() {
        return "RewardDTO{" +
                "rewCode='" + rewCode + '\'' +
                ", rewNum=" + rewNum +
                ", proCode=" + proCode +
                ", rewName='" + rewName + '\'' +
                ", rewExplain='" + rewExplain + '\'' +
                ", rewSf=" + rewSf +
                ", rewardOptDTOList=" + rewardOptDTOList +
                '}';
    }
}
