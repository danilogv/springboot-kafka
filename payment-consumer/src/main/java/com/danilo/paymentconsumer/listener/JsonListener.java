package com.danilo.paymentconsumer.listener;

import com.danilo.paymentconsumer.domain.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "create-payment-group",containerFactory = "jsonContainerFactory")
    public void createPayment(@Payload Payment payment) {
        log.info(payment);

        //salvar no banco de dados ...

        log.info("Creating payment with id = " + payment.getId());

        Thread.sleep(2000); //Criar outros microserviços para consumir o mesmo tópico
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "pdf-payment-group",containerFactory = "jsonContainerFactory")
    public void pdfPayment(@Payload Payment payment) {
        log.info(payment);
        //gerar pdf ...
        log.info("Generating pdf to payment with id = " + payment.getId());
        Thread.sleep(2000); //Criar outros microserviços para consumir o mesmo tópico
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "email-payment-group",containerFactory = "jsonContainerFactory")
    public void emailPayment(@Payload Payment payment) {
        log.info(payment);
        //enviar e-mail ...
        log.info("Sending email to payment with id = " + payment.getId());
        Thread.sleep(2000); //Criar outros microserviços para consumir o mesmo tópico
    }

}
