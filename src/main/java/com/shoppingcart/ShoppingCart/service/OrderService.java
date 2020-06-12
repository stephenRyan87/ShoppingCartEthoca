package com.shoppingcart.ShoppingCart.service;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import com.shoppingcart.ShoppingCart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrder saveOrder(CustomerOrder customerOrder){
        return orderRepository.save(customerOrder);
    }
}
