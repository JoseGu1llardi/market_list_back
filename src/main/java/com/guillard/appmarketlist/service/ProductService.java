package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.Product;
import com.guillard.appmarketlist.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public Product createNewProduct(Product newProduct) {
        if (newProduct.getName() == null || newProduct.getName().isEmpty()) {
            return null;
        }
        return repository.save(newProduct);
    }

    @Override
    public List<Product> listAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return repository.findAllByNameContaining(keyword);
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
}
