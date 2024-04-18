package com.danilo.strconsumer.listener;

import com.danilo.strconsumer.utility.StringConsumerUtility;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Log4j2
public class StringConsumerListener {

    @SneakyThrows
    @StringConsumerUtility(groupId = "group-0")
    public void create(String message) {
        if (message.contains("Test")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error");
        }

        log.info("CREATE ::: Received message : " + message);
    }

    @StringConsumerUtility(groupId = "group-1")
    public void generatePdf(String message) {
        log.info("GENERATE-PDF ::: Received message : " + message);
    }

    @StringConsumerUtility(groupId = "group-2")
    public void history(String message) {
        log.info("HISTORY ::: Received message : " + message);
    }

}
