package com.cg.PaymentService.client;

import com.cg.PaymentService.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductClient {

    @GetMapping("/product/{productId}")
    Product getProduct(@PathVariable UUID productId);
}
