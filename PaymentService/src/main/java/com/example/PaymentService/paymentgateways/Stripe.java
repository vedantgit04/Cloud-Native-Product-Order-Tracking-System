package com.example.PaymentService.paymentgateways;


import org.springframework.stereotype.Component;

@Component
public class Stripe implements PaymentGateways {
    @Override
    public  String CreatePaymentLink(Long orderid){
        return  null;
    }
}
