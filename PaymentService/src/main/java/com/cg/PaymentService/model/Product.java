package com.cg.PaymentService.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {
    private UUID productId;
    private String name;
    private int price;
}
