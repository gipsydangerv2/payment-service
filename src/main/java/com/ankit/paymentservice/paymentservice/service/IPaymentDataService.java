package com.ankit.paymentservice.paymentservice.service;

import com.ankit.paymentservice.paymentservice.model.PaymentInfo;

import java.util.List;

public interface IPaymentDataService {
    PaymentInfo getPaymentInfoForUser(String userId);
    List<PaymentInfo> getAllPaymentInfo();
}
