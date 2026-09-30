package com.cg.PaymentService.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {
    private UUID orderId;
    private int totalPrice;
    private String customerName;
    private UUID productId;
}
