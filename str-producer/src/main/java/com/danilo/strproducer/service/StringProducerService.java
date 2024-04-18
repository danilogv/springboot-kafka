package com.danilo.strproducer.service;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Log4j2
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Send message : " + message);
        CompletableFuture<SendResult<String,String>> sentMessage = this.kafkaTemplate.send("str-topic",message);

        try {
            RecordMetadata record = sentMessage.get().getRecordMetadata();
            log.info("Message sent");
            log.info("Partition : " + record.partition());
            log.info("Offset : " + record.offset());
        }
        catch (InterruptedException | ExecutionException ex) {
            log.error("Message sent failed : " + ex.getMessage());
        }

    }

}
