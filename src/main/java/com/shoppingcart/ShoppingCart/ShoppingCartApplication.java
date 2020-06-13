package com.shoppingcart.ShoppingCart;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import com.shoppingcart.ShoppingCart.entity.OrderProduct;
import com.shoppingcart.ShoppingCart.entity.Product;
import com.shoppingcart.ShoppingCart.repository.OrderRepository;
import com.shoppingcart.ShoppingCart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class ShoppingCartApplication {

	private static final Logger log = LoggerFactory.getLogger(ShoppingCartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository, OrderRepository orderRepository) {
		return (args) -> {
			repository.save(new Product("Vaacuum", 70.0));
			repository.save(new Product("spoon", 5.0));


			OrderProduct orderProduct1 = new OrderProduct("Vacuum", 70.0, 2);
			OrderProduct orderProduct2 = new OrderProduct("Washing Machine", 200.0, 1);

			List<OrderProduct> orderProducts = new ArrayList<>();
			orderProducts.add(orderProduct1);
			orderProducts.add(orderProduct2);

			OrderProduct orderProduct3= new OrderProduct("Vacuumh", 75.0, 3);
			OrderProduct orderProduct4 = new OrderProduct("Washing Machine2", 250.0, 1);

			List<OrderProduct> orderProducts2 = new ArrayList<>();
			orderProducts2.add(orderProduct3);
			orderProducts2.add(orderProduct4);

			CustomerOrder customerOrder = new CustomerOrder(orderProducts);
			CustomerOrder customerOrder1 = new CustomerOrder(orderProducts2);


			orderRepository.save(customerOrder);
			orderRepository.save(customerOrder1);


			for (Product product : repository.findAll()) {
				log.info("The product is: " + product.toString());
			}
		};
	}

}
