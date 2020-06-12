package com.shoppingcart.ShoppingCart.repository;


import com.shoppingcart.ShoppingCart.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
