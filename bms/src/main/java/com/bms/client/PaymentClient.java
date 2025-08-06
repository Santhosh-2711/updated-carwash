package com.bms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bms.dto.PaymentRequest;
import com.bms.dto.PaymentResponse;

@FeignClient(name = "payment-service", url = "http://localhost:8081")
public interface PaymentClient {
    
    @PostMapping("/api/payments/process")
    PaymentResponse processPayment(@RequestBody PaymentRequest paymentRequest);
}
</create_file>
