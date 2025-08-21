package com.example.PaymentService.Dtos;

public class CreatePaymentLinkRequestDto {

    private  Long orderid;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }
}
