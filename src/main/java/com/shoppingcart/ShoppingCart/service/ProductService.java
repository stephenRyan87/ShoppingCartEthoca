package com.shoppingcart.ShoppingCart.service;

import com.shoppingcart.ShoppingCart.entity.Product;
import com.shoppingcart.ShoppingCart.repository.ProductRepository;
import dto.ProductCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductCollection getAllProducts(){
        Iterable<Product> products= productRepository.findAll();

        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);

        return new ProductCollection(productList);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
