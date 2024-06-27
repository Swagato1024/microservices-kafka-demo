package com.xyz.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private String name;
    private int quantity;
    private double price;
}
