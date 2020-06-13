package com.shoppingcart.ShoppingCart.rest;

import com.shoppingcart.ShoppingCart.service.OrderService;
import com.shoppingcart.ShoppingCart.service.ProductService;
import dto.CustomerOrderDTO;
import dto.ProductCollectionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<ProductCollectionDTO> getAllProducts() {
        ProductCollectionDTO products = productService.getAllProducts();
        return new ResponseEntity<ProductCollectionDTO>(products, HttpStatus.OK);
    }

    @PostMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createOrder(@RequestBody CustomerOrderDTO customerOrderDTO) {
        orderService.saveOrder(customerOrderDTO);
    }
}
