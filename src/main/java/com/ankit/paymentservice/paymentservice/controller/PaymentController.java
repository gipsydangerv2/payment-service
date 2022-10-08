package com.ankit.paymentservice.paymentservice.controller;

import com.ankit.paymentservice.paymentservice.model.PaymentInfo;
import com.ankit.paymentservice.paymentservice.service.IPaymentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private IPaymentDataService paymentDataService;

    @GetMapping("/paymentInfo/{userId}")
    public ResponseEntity<PaymentInfo> getPaymentInfoForUser(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(paymentDataService.getPaymentInfoForUser(userId), HttpStatus.OK);
    }

    @GetMapping("/allPaymentInfo")
    public ResponseEntity<List<PaymentInfo>> getAllPaymentInfo() {
        return new ResponseEntity<>(paymentDataService.getAllPaymentInfo(), HttpStatus.OK);
    }
}
