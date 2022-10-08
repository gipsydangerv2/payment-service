package com.ankit.paymentservice.paymentservice.model;

import com.ankit.paymentservice.paymentservice.enums.PaymentMode;
import com.ankit.paymentservice.paymentservice.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
    private String paymentId;
    private String userId;
    private LocalDateTime time;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
