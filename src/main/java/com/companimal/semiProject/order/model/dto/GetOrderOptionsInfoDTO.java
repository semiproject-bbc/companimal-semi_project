package com.companimal.semiProject.order.model.dto;

import java.util.ArrayList;
import java.util.List;

public class GetOrderOptionsInfoDTO {

    private String rewName;
    private String rewSf;
    private String rewOptCode;
    private String rewOptName;
    private String rewOptVal;
    private String rewAmount;
    private String noOfOrder;

//    private ArrayList<GetOrderOptionsInfoDTO> optionsInfoDTOList;

    public GetOrderOptionsInfoDTO() {
    }

    public GetOrderOptionsInfoDTO(String rewName, String rewSf, String rewOptCode, String rewOptName, String rewOptVal, String rewAmount, String noOfOrder) {
        this.rewName = rewName;
        this.rewSf = rewSf;
        this.rewOptCode = rewOptCode;
        this.rewOptName = rewOptName;
        this.rewOptVal = rewOptVal;
        this.rewAmount = rewAmount;
        this.noOfOrder = noOfOrder;
    }

//    public List<GetOrderOptionsInfoDTO> getOptionsInfoDTOList() {
//        return optionsInfoDTOList;
//    }
//
//    public void setOptionsInfoDTOList(ArrayList<GetOrderOptionsInfoDTO> optionsInfoDTOList) {
//        this.optionsInfoDTOList = optionsInfoDTOList;
//    }

    public String getRewName() {
        return rewName;
    }

    public void setRewName(String rewName) {
        this.rewName = rewName;
    }

    public String getRewSf() {
        return rewSf;
    }

    public void setRewSf(String rewSf) {
        this.rewSf = rewSf;
    }

    public String getRewOptCode() {
        return rewOptCode;
    }

    public void setRewOptCode(String rewOptCode) {
        this.rewOptCode = rewOptCode;
    }

    public String getRewOptName() {
        return rewOptName;
    }

    public void setRewOptName(String rewOptName) {
        this.rewOptName = rewOptName;
    }

    public String getRewOptVal() {
        return rewOptVal;
    }

    public void setRewOptVal(String rewOptVal) {
        this.rewOptVal = rewOptVal;
    }

    public String getRewAmount() {
        return rewAmount;
    }

    public void setRewAmount(String rewAmount) {
        this.rewAmount = rewAmount;
    }

    public String getNoOfOrder() {
        return noOfOrder;
    }

    public void setNoOfOrder(String noOfOrder) {
        this.noOfOrder = noOfOrder;
    }

    @Override
    public String toString() {
        return "GetOrderOptionsInfoDTO{" +
                "rewName='" + rewName + '\'' +
                ", rewSf='" + rewSf + '\'' +
                ", rewOptCode='" + rewOptCode + '\'' +
                ", rewOptName='" + rewOptName + '\'' +
                ", rewOptVal='" + rewOptVal + '\'' +
                ", rewAmount='" + rewAmount + '\'' +
                ", noOfOrder='" + noOfOrder + '\'' +
                '}';
    }
}
