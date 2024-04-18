package com.danilo.paymentproducer.controller;

import com.danilo.paymentproducer.domain.Payment;
import com.danilo.paymentproducer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
        this.service.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
