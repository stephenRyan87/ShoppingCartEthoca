package com.shoppingcart.ShoppingCart;

import com.shoppingcart.ShoppingCart.service.OrderService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.shoppingcart.ShoppingCart.service.ProductService;

@Configuration
@EnableAutoConfiguration
public class ShoppingCartConfiguration {

    @Bean
    public ProductService productService(){
        return new ProductService();
    }

    @Bean
    public OrderService orderService(){
        return new OrderService();
    }
}
