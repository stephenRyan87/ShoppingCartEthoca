package com.shoppingcart.ShoppingCart.rest;

import com.shoppingcart.ShoppingCart.entity.CustomerOrder;
import com.shoppingcart.ShoppingCart.service.OrderService;
import com.shoppingcart.ShoppingCart.service.ProductService;
import dto.ProductCollection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ProductService productService;
    private final OrderService orderService;

    public ShoppingCartController(ProductService productService, OrderService orderService){
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public ResponseEntity<ProductCollection> getAllProducts() {
        ProductCollection products = productService.getAllProducts();
        return new ResponseEntity<ProductCollection>(products, HttpStatus.OK);
    }

    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.OK)
    public void createOrder(@RequestBody CustomerOrder customerOrder) {
        orderService.saveOrder(customerOrder);
    }


}
