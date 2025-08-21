package com.example.PaymentService.paymentgateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Component
@Primary
public class RazorPay  implements  PaymentGateways{

      private  RazorpayClient razorpayClient;

       RazorPay(RazorpayClient razorpayClient){
          this.razorpayClient = razorpayClient;
      }
     @Override
    public  String CreatePaymentLink(Long orderid) {
          // first we are calling order service and passing order id in the order service and then gets all the values from that api call to generate payment link




         // this is the copied code from the documentation of razorpay
         // we are creating a object of razorpay client so that we this request gos to razorpayserver by using keyid and screatkey razarpy identify from which client the request comes
       // we dont use the flot to store the financial data because it gets roundoff for large number
         JSONObject paymentLinkRequest = new JSONObject();
         paymentLinkRequest.put("amount",1000); // this is not 1000 this is 10 because in the format 10.00 is store as 1000
         paymentLinkRequest.put("currency","INR");
//         paymentLinkRequest.put("accept_partial",true);
//         paymentLinkRequest.put("first_min_partial_amount",100);

         // Calculate a new timestamp 30 minutes in the future
         long expireBy = System.currentTimeMillis() / 1000L + (30 * 60);
         paymentLinkRequest.put("expire_by", expireBy);
         paymentLinkRequest.put("reference_id",orderid.toString());
         paymentLinkRequest.put("description", "Payment for this "+ orderid.toString()+"order id");
         JSONObject customer = new JSONObject();
         customer.put("name","vedant");
         customer.put("contact","9271142945");
         customer.put("email","vedantdhole04@gmail.com");
         paymentLinkRequest.put("customer",customer);
         JSONObject notify = new JSONObject();
         notify.put("sms",true);
         notify.put("email",true);
         paymentLinkRequest.put("notify",notify);
         paymentLinkRequest.put("reminder_enable",true);
         JSONObject notes = new JSONObject();
         notes.put("policy_name","Life Insurance Policy");
         paymentLinkRequest.put("notes",notes);
         paymentLinkRequest.put("callback_url","https://start.spring.io/");
         paymentLinkRequest.put("callback_method","get");

         PaymentLink payment =null;
         try {
           payment = razorpayClient.paymentLink.create(paymentLinkRequest);
         }catch (RazorpayException e){
             throw  new RuntimeException(e);
         }

         return payment.toString();
    }
}
