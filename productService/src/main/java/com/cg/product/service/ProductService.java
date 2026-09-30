package com.cg.product.service;

import com.cg.product.exception.ProductNotFoundException;
import com.cg.product.model.Product;
import com.cg.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product addProduct(Product product)
    {
        return productRepository.save(product);
    }

    public Product getProductById(UUID id)
    {
        //Supplier is a functional Interface, we can use a lambda Expression
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not found. Product Id is invalid"));
    }

    public Product updateProduct(UUID id, Product product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not found. Product Id is invalid"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Product product)
    {
        productRepository.delete(product);
    }

    public void deleteProductById(UUID id)
    {
        productRepository.deleteById(id);
    }
}
