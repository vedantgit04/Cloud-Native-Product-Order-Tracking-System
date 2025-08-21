package com.example.PaymentService.Controller;


import com.example.PaymentService.Dtos.CreatePaymentLinkRequestDto;
import com.example.PaymentService.Service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @PostMapping("/")
    public  String CreatePaymentLink(@RequestBody  CreatePaymentLinkRequestDto createPaymentLinkRequestDto){
        Long orderid = createPaymentLinkRequestDto.getOrderid();
         return  paymentService.CreatePaymentLink(orderid);
    }
}
