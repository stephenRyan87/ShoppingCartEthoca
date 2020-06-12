package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ElementCollection
    @CollectionTable(name = "customer_order_products", joinColumns = @JoinColumn(name = "customer_order_id"))
    @Column(name = "order_products")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    private double totalPrice;

    public CustomerOrder() {}

    public CustomerOrder(List<OrderProduct> orderProducts){
        this.orderProducts = orderProducts;
        this.totalPrice = calculateTotalPrice(orderProducts);
    }

    private double calculateTotalPrice(List<OrderProduct> orderProducts) {
         double price = orderProducts.stream()
                 .mapToDouble(op -> (op.getPrice() * op.getQuantity())).sum();

        return price;
    }

}
