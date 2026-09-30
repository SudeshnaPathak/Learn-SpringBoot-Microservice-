package com.cg.PaymentService.service;

import com.cg.PaymentService.client.OrderClient;
import com.cg.PaymentService.client.ProductClient;
import com.cg.PaymentService.dto.PaymentWithOrderWithProduct;
import com.cg.PaymentService.model.Order;
import com.cg.PaymentService.model.Payment;
import com.cg.PaymentService.model.Product;
import com.cg.PaymentService.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderClient orderClient;
    private final ProductClient productClient;

    public Payment findByPaymentId(UUID paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public PaymentWithOrderWithProduct getPaymentWithOrderWithProduct(UUID paymentId) {
        Payment payment = findByPaymentId(paymentId);
        UUID orderId = payment.getOrderId();
        Order order = orderClient.getOrder(orderId);
        UUID productId = order.getProductId();
        Product product = productClient.getProduct(productId);
        return new PaymentWithOrderWithProduct(payment, order, product);
    }

}
