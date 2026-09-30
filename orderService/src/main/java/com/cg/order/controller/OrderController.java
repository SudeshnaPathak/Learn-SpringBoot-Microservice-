package com.cg.order.controller;

import com.cg.order.dto.OrderWithProduct;
import com.cg.order.model.Order;
import com.cg.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID orderId) {
        return new  ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getOrderWithProduct/{orderId}")
    public ResponseEntity<OrderWithProduct> getOrderWithProduct(@PathVariable UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderWithProduct(orderId));
    }

}
