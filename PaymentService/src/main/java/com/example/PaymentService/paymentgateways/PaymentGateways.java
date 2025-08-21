package com.example.PaymentService.paymentgateways;

import com.razorpay.RazorpayException;

public interface PaymentGateways {
    public  String CreatePaymentLink(Long orderid);
}
