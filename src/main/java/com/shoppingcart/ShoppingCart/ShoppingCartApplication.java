package com.shoppingcart.ShoppingCart;

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
			repository.save(new Product("Vacuum", 7.0));
			repository.save(new Product("spoon", 500.0));

			for (Product product : repository.findAll()) {
				log.info("The product is: " + product.toString());
			}
		};
	}
}
