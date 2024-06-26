package com.xyz.order_service.kafka;

import com.xyz.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderEvent event) {
        logger.info("Sending order event: {}", event.toString());
        kafkaTemplate.send(topicName, event);
    }
}
