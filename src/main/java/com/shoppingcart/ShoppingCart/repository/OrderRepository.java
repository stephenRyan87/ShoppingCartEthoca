package com.shoppingcart.ShoppingCart.repository;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {
}
