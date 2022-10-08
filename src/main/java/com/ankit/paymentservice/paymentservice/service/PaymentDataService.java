package com.ankit.paymentservice.paymentservice.service;

import com.ankit.paymentservice.paymentservice.model.PaymentInfo;
import com.ankit.paymentservice.paymentservice.repository.PaymentHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDataService implements IPaymentDataService {

    @Override
    public PaymentInfo getPaymentInfoForUser(String userId) {
        return PaymentHistoryRepository.getPaymentInfoForUser(userId);
    }

    @Override
    public List<PaymentInfo> getAllPaymentInfo() {
        return PaymentHistoryRepository.getAllPaymentInfo();
    }
}
