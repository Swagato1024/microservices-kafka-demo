package com.xyz.order_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private NewTopic topic;
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

}
