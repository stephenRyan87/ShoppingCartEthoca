package com.shoppingcart.ShoppingCart.repository;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {
}
