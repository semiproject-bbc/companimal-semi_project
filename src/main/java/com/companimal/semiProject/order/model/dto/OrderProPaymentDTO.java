package com.companimal.semiProject.order.model.dto;

import java.sql.Timestamp;

public class OrderProPaymentDTO {

    private String orderCode;       // 주문 코드
    private Timestamp orderDate;    // 주문 일시
    private String memId;           // 아이디
    private String address;         // 주소
    private String request;         // 배송 시 요청 사항
    private String recipient;       // 수취인명
    private int finalCalPay;           // 최종 결제 금액
    private int orderProCode;            // 프로젝트 코드
    private String couCode;         // 쿠폰 코드
    private Timestamp purchaseStatus;   // 구매 확정 일시

    public OrderProPaymentDTO() {
    }

    public OrderProPaymentDTO(String orderCode, Timestamp orderDate, String memId, String address, String request, String recipient, int finalCalPay, int orderProCode, String couCode, Timestamp purchaseStatus) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.memId = memId;
        this.address = address;
        this.request = request;
        this.recipient = recipient;
        this.finalCalPay = finalCalPay;
        this.orderProCode = orderProCode;
        this.couCode = couCode;
        this.purchaseStatus = purchaseStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getFinaCalPay() {
        return finalCalPay;
    }

    public void setFinalCalPay(int finalCalPay) {
        this.finalCalPay = finalCalPay;
    }

    public int getOrderProCode() {
        return orderProCode;
    }

    public void setOrderProCode(int orderProCode) {
        this.orderProCode = orderProCode;
    }

    public String getCouCode() {
        return couCode;
    }

    public void setCouCode(String couCode) {
        this.couCode = couCode;
    }

    public Timestamp getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Timestamp purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    @Override
    public String toString() {
        return "OrderPaymentDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderDate=" + orderDate +
                ", memId='" + memId + '\'' +
                ", address='" + address + '\'' +
                ", request='" + request + '\'' +
                ", recipient='" + recipient + '\'' +
                ", finalCalPay=" + finalCalPay +
                ", proCode=" + orderProCode +
                ", couCode='" + couCode + '\'' +
                ", purchaseStatus=" + purchaseStatus +
                '}';
    }
}
