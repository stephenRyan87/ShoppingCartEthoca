package com.shoppingcart.ShoppingCart.dto;

import com.shoppingcart.ShoppingCart.entity.OrderProduct;

import java.util.List;

public class CustomerOrderDTO {

    private List<OrderProduct> orderProducts;

    protected CustomerOrderDTO() {}

    public CustomerOrderDTO(List<OrderProduct> orderProducts){
        this.orderProducts = orderProducts;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
