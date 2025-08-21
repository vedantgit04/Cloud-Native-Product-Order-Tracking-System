package com.example.PaymentService.Service;

import com.example.PaymentService.paymentgateways.PaymentGateways;
import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
      private PaymentGateways paymentGateways;
      PaymentService(PaymentGateways paymentGateways){
          this.paymentGateways = paymentGateways;
      }
    public String CreatePaymentLink(Long orderid) {
        // call razorpay / stripe pg to generate payment link
        return paymentGateways.CreatePaymentLink(orderid);
    }
}
