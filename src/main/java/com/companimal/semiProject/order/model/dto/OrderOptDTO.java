package com.companimal.semiProject.order.model.dto;


public class OrderOptDTO {

    private String orderNo;     // 주문 코드
    private String rewOptCode;  // 리워드 옵션 코드
    private int orderAmount;    // 주문 수량

    public OrderOptDTO() {
    }

    public OrderOptDTO(String orderNo, String rewOptCode, int orderAmount) {
        this.orderNo = orderNo;
        this.rewOptCode = rewOptCode;
        this.orderAmount = orderAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRewOptCode() {
        return rewOptCode;
    }

    public void setRewOptCode(String rewOptCode) {
        this.rewOptCode = rewOptCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderOpDTO{" +
                "orderNo='" + orderNo + '\'' +
                ", rewOptCode='" + rewOptCode + '\'' +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
