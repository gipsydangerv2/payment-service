package com.ankit.paymentservice.paymentservice.repository;

import com.ankit.paymentservice.paymentservice.enums.PaymentMode;
import com.ankit.paymentservice.paymentservice.enums.PaymentStatus;
import com.ankit.paymentservice.paymentservice.model.PaymentInfo;

import java.time.LocalDateTime;
import java.util.*;

public class PaymentHistoryRepository {
    private static Map<String, PaymentInfo> paymentInfoMap;

    static {
        paymentInfoMap = new HashMap<>();

        for (int idx = 0; idx < 10; idx++) {
            String paymentId = "payment-id-#" + (idx + 1);
            String userId = "userId-" + (idx % 4);
            PaymentInfo paymentInfo = new PaymentInfo(paymentId, userId, LocalDateTime.now(),
                    getPaymentStatus(idx, 4), getPaymentMode(idx, 3));
            paymentInfoMap.put(paymentId, paymentInfo);
        }
    }

    public static PaymentInfo getPaymentInfoForUser(String userId) {
        Optional<Map.Entry<String, PaymentInfo>> result = paymentInfoMap.entrySet()
                .stream()
                .filter(data -> data.getValue().getUserId().equals(userId))
                .findFirst();

        return result.map(Map.Entry::getValue).orElse(null);
    }

    public static List<PaymentInfo> getAllPaymentInfo() {
        return new ArrayList<>(paymentInfoMap.values());
    }

    private static PaymentStatus getPaymentStatus(int idx, int size) {
        PaymentStatus paymentStatus = null;
        switch (idx % size) {
            case 1:
                paymentStatus = PaymentStatus.RETRY;
                break;
            case 2:
                paymentStatus = PaymentStatus.IN_PROGRESS;
                break;
            case 0:
            default:
                paymentStatus = PaymentStatus.COMPLETED;
        }
        return paymentStatus;
    }

    private static PaymentMode getPaymentMode(int idx, int size) {
        PaymentMode paymentMode = null;
        switch (idx % size) {
            case 0:
                paymentMode = PaymentMode.CARD;
                break;
            case 2:
                paymentMode = PaymentMode.UPI;
                break;
            case 1:
            default:
                paymentMode = PaymentMode.CASH;
        }
        return paymentMode;
    }
}
