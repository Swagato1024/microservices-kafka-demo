package com.xyz.order_service.controller;

import com.xyz.base_domains.dto.Order;
import com.xyz.base_domains.dto.OrderEvent;
import com.xyz.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        System.out.println("----------------> Request Received <---------------");
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is pending");
        orderEvent.setOrder(order);

        orderProducer.sendOrderEvent(orderEvent);
        return "Order placed successfully";
    }
}
