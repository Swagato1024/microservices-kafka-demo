package com.xyz.email_service.kafka;

import com.xyz.domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "order_topic", groupId = "email-sender", containerFactory = "kafkaListenerContainerFactory")
    public void listen(OrderEvent event) {
        logger.info("Received event in email sender group {}", event);
    }
}
