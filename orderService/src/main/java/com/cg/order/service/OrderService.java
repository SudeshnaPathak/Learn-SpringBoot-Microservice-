package com.cg.order.service;

import com.cg.order.client.ProductClient;
import com.cg.order.dto.OrderWithProduct;
import com.cg.order.model.Order;
import com.cg.order.model.Product;
import com.cg.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
//    private final RestTemplate restTemplate;
//    private final RestClient restClient;
    private final ProductClient productClient;

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(UUID orderId) {
        return orderRepository.findById(orderId).get();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderWithProduct getOrderWithProduct(UUID orderId)
    {
        Order order = getOrderById(orderId);
        UUID productId = order.getProductId();
//        String url = "http://PRODUCTSERVICE/product/";
//        Product product = restTemplate.getForObject(url+productId, Product.class);
//        Product product = restClient.get().uri(url+productId.toString()).retrieve().body(Product.class);
        Product product = productClient.getProduct(productId);
        return new OrderWithProduct(order, product);
    }
}
