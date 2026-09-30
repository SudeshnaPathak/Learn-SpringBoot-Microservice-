package com.cg.PaymentService.dto;

import com.cg.PaymentService.model.Order;
import com.cg.PaymentService.model.Payment;
import com.cg.PaymentService.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentWithOrderWithProduct {
    Payment payment;
    Order order;
    Product product;
}
