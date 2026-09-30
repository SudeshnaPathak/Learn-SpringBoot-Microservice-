package com.cg.order.dto;

import com.cg.order.model.Order;
import com.cg.order.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderWithProduct {
    private Order order;
    private Product product;
}
