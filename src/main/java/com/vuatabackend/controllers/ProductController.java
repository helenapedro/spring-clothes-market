package com.vuatabackend.controllers;

import com.vuatabackend.entities.Product;
import com.vuatabackend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
    // Endpoint to retrieve the list of categories
    @GetMapping("/categories")
    public ResponseEntity<List<Product.Category>> getCategories() {
        List<Product.Category> categories = Arrays.asList(Product.Category.values());
        return ResponseEntity.ok(categories);
    }

    // Endpoint to retrieve the list of conditions
    @GetMapping("/conditions")
    public ResponseEntity<List<Product.Condition>> getConditions() {
        List<Product.Condition> conditions = Arrays.asList(Product.Condition.values());
        return ResponseEntity.ok(conditions);
    }
}
