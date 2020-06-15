package com.shoppingcart.ShoppingCart.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    @CollectionTable(name = "customer_order_products", joinColumns = @JoinColumn(name = "customer_order_id"))
    @Column(name = "order_products")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    private double totalPrice;

    private int noOfItemsInOrder;

    public CustomerOrder() {}

    public CustomerOrder(List<OrderProduct> orderProducts){
        this.orderProducts = orderProducts;
        this.totalPrice = calculateTotalPrice(orderProducts);
        this.noOfItemsInOrder = calculateNoOfItems(orderProducts);
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    private int calculateNoOfItems(List<OrderProduct> orderProducts) {
        return orderProducts.stream().mapToInt(OrderProduct::getQuantity).sum();
    }

    private double calculateTotalPrice(List<OrderProduct> orderProducts) {
        return orderProducts.stream()
                .mapToDouble(op -> (op.getPrice() * op.getQuantity())).sum();
    }

}
