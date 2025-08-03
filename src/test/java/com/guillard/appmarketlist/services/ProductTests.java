package com.guillard.appmarketlist.services;

import com.guillard.appmarketlist.model.Product;
import com.guillard.appmarketlist.repository.IProductRepository;
import com.guillard.appmarketlist.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProductTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private IProductRepository repository;

    private Integer existingId = 1;
    private Integer nonExistingId = 100;
    private String keyword = "cookie";
    private Product newProduct;
    private Product createdProduct;
    private ArrayList<Product> productsList;

    @BeforeEach
    public void setup() throws  Exception {
        newProduct = new Product();
        newProduct.setName("cookie");
        
        createdProduct = new Product();
        createdProduct.setName("cookie");
        createdProduct.setId(existingId);

        productsList = new ArrayList<>();
        Product product1, product2;

        product1 = new Product();
        product1.setId(2);
        product1.setName("Oreo");

        product2 = new Product();
        product2.setId(3);
        product2.setName("Nutella");

        productsList.add(product1);
        productsList.add(product2);

        Mockito.when(repository.save(newProduct)).thenReturn(createdProduct);
        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(new Product()));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
        Mockito.when(repository.findAllByNameContaining("Cookie")).thenReturn(new ArrayList<>());
        Mockito.when(repository.findAllByNameContaining(keyword)).thenReturn(productsList);
    }

    @Test
    public void shouldRecordProduct() {
        assertEquals(service.createNewProduct(newProduct), createdProduct);
    }

    @Test
    public void shouldReturnById() {
        assertNotNull(service.getProductById(existingId));
    }

    @Test
    public void shouldNotFindId() {
        assertNull(service.getProductById(nonExistingId));
    }

    @Test
    public void shouldReturnListWithKeyword() {
        assertFalse(service.searchByKeyword(keyword).isEmpty());
    }

    @Test
    public void shouldReturnEmptyList() {
        assertTrue(service.searchByKeyword("Java").isEmpty());
    }
}
