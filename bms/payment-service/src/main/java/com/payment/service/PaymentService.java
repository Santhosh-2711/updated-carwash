package com.payment.service;

import com.payment.dto.PaymentRequest;
import com.payment.dto.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        Stripe.apiKey = stripeSecretKey;

        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount((long) (paymentRequest.getAmount() * 100)) // Convert to cents
                    .setCurrency(paymentRequest.getCurrency())
                    .setDescription(paymentRequest.getDescription())
                    .putMetadata("bookingId", paymentRequest.getBookingId().toString())
                    .putMetadata("userId", paymentRequest.getUserId().toString())
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            PaymentResponse response = new PaymentResponse();
            response.setPaymentId(paymentIntent.getId());
            response.setStatus(paymentIntent.getStatus());
            response.setMessage("Payment processed successfully");
            response.setTransactionId(paymentIntent.getId());

            return response;

        } catch (StripeException e) {
            PaymentResponse response = new PaymentResponse();
            response.setStatus("failed");
            response.setMessage("Payment failed: " + e.getMessage());
            return response;
        }
    }
}
