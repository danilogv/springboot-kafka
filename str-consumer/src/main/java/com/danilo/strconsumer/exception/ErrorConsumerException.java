package com.danilo.strconsumer.exception;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ErrorConsumerException implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message,ListenerExecutionFailedException exception) {
        this.logError(message,exception);
        return null;
    }

    @Override
    public Object handleError(Message<?> message,ListenerExecutionFailedException exception,Consumer<?,?> consumer) {
        this.logError(message,exception);
        return KafkaListenerErrorHandler.super.handleError(message,exception,consumer);
    }

    @Override
    public Object handleError(Message<?> message,ListenerExecutionFailedException exception,Consumer<?,?> consumer,Acknowledgment ack) {
        this.logError(message,exception);
        return KafkaListenerErrorHandler.super.handleError(message,exception,consumer,ack);
    }

    private void logError(Message<?> message,ListenerExecutionFailedException exception) {
        log.error("PAYLOAD ::: " + message.getPayload());
        log.error("HEADERS ::: " + message.getHeaders());
        log.error("ERROR ::: " + exception.getMessage());
    }

}
