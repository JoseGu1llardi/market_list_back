package com.guillard.appmarketlist.controller;

import com.guillard.appmarketlist.model.Product;
import com.guillard.appmarketlist.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/product")
    public ResponseEntity<Product> registerNew(@RequestBody Product newProduct) {
        Product product = service.createNewProduct(newProduct);
        if (product != null) {
            return ResponseEntity.status(201).body(product);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.of(Optional.ofNullable(service.listAllProducts()));
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchByKeyword(@RequestParam(name = "k") String keyword) {
        return ResponseEntity.of(Optional.ofNullable(service.searchByKeyword(keyword)));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id) {
        Product res = service.getProductById(id);
        if (res != null) {
            return ResponseEntity.status(200).body(res);
        }
        return ResponseEntity.notFound().build();
    }
}
