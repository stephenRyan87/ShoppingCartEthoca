package com.shoppingcart.ShoppingCart.service;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import com.shoppingcart.ShoppingCart.repository.OrderRepository;
import dto.CustomerOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrder saveOrder(CustomerOrderDTO customerOrderDTO){
        CustomerOrder co = new CustomerOrder(customerOrderDTO.getOrderProducts());
        return orderRepository.save(co);
    }
}
