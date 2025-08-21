package com.example.PaymentService.Configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    // by using value annotaton we are using env variables from apllication.properties
    @Value("${razorpay.key.id}")
    private  String RazorPayKeyId;
    @Value("${RAZORPAY_KEY_SECRET}")
    private  String RazorpayKeySecret;

    @Bean
    public RazorpayClient  getRazorpayClient() throws RazorpayException {
        // these keyid and screate key is generated using rzaorpay api

        return new RazorpayClient(RazorPayKeyId, RazorpayKeySecret);
    }
}
