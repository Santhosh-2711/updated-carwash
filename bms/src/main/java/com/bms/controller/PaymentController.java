package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bms.client.PaymentClient;
import com.bms.dto.PaymentRequest;
import com.bms.dto.PaymentResponse;
import com.bms.model.Bookings;
import com.bms.service.BmsService;

@RestController
@RequestMapping("/api/bookings")
public class BookingPaymentController {

    @Autowired
    private PaymentClient paymentClient;
    
    @Autowired
    private BmsService bmsService;

    @PostMapping("/{bookingId}/payment")
    public ResponseEntity<PaymentResponse> processBookingPayment(
            @PathVariable Long bookingId,
            @RequestParam Double amount,
            @RequestParam String currency) {
        
        Bookings booking = bmsService.getOne(bookingId);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setBookingId(bookingId);
        paymentRequest.setAmount(amount);
        paymentRequest.setCurrency(currency);
        paymentRequest.setDescription("Car wash booking - " + booking.getC_name());
        paymentRequest.setUserId(booking.getUserId());
        
        PaymentResponse response = paymentClient.processPayment(paymentRequest);
        return ResponseEntity.ok(response);
    }
}
