package com.cg.product.controller;

import com.cg.product.model.Product;
import com.cg.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID productId)
    {
        return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable UUID productId,
            @RequestBody Product product) {

        return new ResponseEntity<>(productService.updateProduct(productId, product), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID productId)
    {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }


}
