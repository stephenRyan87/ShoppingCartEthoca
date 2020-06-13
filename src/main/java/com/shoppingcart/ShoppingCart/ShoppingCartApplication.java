package com.shoppingcart.ShoppingCart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

			List<OrderProduct> orderProducts = new ArrayList<>();
			OrderProduct p1 = new OrderProduct("spoon", 10.0, 3);
			OrderProduct p2 = new OrderProduct("fridge", 1000.0, 1);
			orderProducts.add(p1);
			orderProducts.add(p2);

			CustomerOrder o1 = new CustomerOrder(orderProducts);

			Gson gsonBuilder = new GsonBuilder().create();
			String jsonFromPojo = gsonBuilder.toJson(o1);
			System.out.println(jsonFromPojo);


			for (Product product : repository.findAll()) {
				log.info("The product is: " + product.toString());
			}
		};
	}

}
