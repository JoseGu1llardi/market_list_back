package com.guillard.appmarketlist.repository;

import com.guillard.appmarketlist.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String keyword);
}
