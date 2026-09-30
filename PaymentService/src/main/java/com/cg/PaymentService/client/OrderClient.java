package com.cg.PaymentService.client;

import com.cg.PaymentService.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "ORDER")
public interface OrderClient {

    @GetMapping("/order/{orderId}")
    Order getOrder(@PathVariable UUID orderId);

}
