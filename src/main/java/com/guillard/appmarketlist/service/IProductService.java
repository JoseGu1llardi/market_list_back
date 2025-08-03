package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.Product;

import java.util.List;

public interface IProductService {
    Product createNewProduct(Product newProduct);
    List<Product> listAllProducts();
    List<Product> searchByKeyword (String keyword);
    Product getProductById(int id);
}
