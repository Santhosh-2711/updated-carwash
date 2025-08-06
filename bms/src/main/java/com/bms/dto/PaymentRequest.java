package com.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Long bookingId;
    private Double amount;
    private String currency;
    private String description;
    private Long userId;
}
</create_file>
