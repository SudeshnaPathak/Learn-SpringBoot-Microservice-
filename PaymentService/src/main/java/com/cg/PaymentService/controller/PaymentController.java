package com.cg.PaymentService.controller;

import com.cg.PaymentService.dto.PaymentWithOrderWithProduct;
import com.cg.PaymentService.model.Payment;
import com.cg.PaymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<List<Payment>> findAllPayments() {
        return new ResponseEntity<>(paymentService.findAllPayments(), HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable("paymentId") UUID paymentId) {
        return new ResponseEntity<>(paymentService.findByPaymentId(paymentId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.createPayment(payment), HttpStatus.CREATED);
    }

    @GetMapping("/paymentWithOrderWithProduct/{paymentId}")
    public ResponseEntity<PaymentWithOrderWithProduct> findPaymentWithOrderWithProduct(@PathVariable("paymentId") UUID paymentId) {
        return new ResponseEntity<>(paymentService.getPaymentWithOrderWithProduct(paymentId), HttpStatus.OK);
    }
}
