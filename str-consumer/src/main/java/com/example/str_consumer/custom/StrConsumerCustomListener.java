package com.example.str_consumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//iNFORMANDO PARA O COMPILADOR QUE ESSA ANOTAÇÃO TEM Q ESTAR EM TEMPO DE EXECUÇÃO
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "topicPartitions")
    TopicPartition[] topicPartitions() default {
            @TopicPartition(topic = "str-topic", partitions = {"0", "1"})
    };
    /*@AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default {"str-topics"};
    */
    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "errorCustomHandler";
}
