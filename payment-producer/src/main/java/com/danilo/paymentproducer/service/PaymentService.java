package com.danilo.paymentproducer.service;

import com.danilo.paymentproducer.domain.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
public class PaymentService {

    @Autowired
    private KafkaTemplate<String,Serializable> kafkaTemplate;

    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("Payment : " + payment);
        Thread.sleep(1000);
        log.info("Sent payment");
        kafkaTemplate.send("payment-topic",payment);
    }

}
