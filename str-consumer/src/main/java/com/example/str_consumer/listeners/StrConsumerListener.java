package com.example.str_consumer.listeners;

<<<<<<< HEAD
import com.example.str_consumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
=======
>>>>>>> parent of 8bc9277 (record intercept)
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class StrConsumerListener {

<<<<<<< HEAD
    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATED ::: Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(topics = "str-topic", groupId = "group-2", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("History ::: Receive message {}", message);
=======
@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void create(String message){
       log.info("Receive message {}", message);
>>>>>>> parent of 8bc9277 (record intercept)
    }
}
