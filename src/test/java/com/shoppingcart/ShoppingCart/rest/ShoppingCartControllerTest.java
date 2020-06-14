package com.shoppingcart.ShoppingCart.rest;

import com.shoppingcart.ShoppingCart.service.OrderService;
import com.shoppingcart.ShoppingCart.service.ProductService;
import com.shoppingcart.ShoppingCart.dto.CustomerOrderDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private OrderService orderService;

    private ShoppingCartController shoppingCartController;

    @Before
    public void before() {
        shoppingCartController = new ShoppingCartController(productService, orderService);
        MockitoAnnotations.initMocks(shoppingCartController);
    }

    @Test
    public void getAllProductsCallsProductService() {
        //Invocation
        shoppingCartController.getAllProducts();

        //Assertion
        Mockito.verify(productService, Mockito.times(1)).getAllProducts();
    }

    @Test
    public void createOrderCallsOrderService() {
        //Given
        CustomerOrderDTO co = new CustomerOrderDTO();

        //Invocation
        shoppingCartController.createOrder(co);

        //Assertion
        Mockito.verify(orderService, Mockito.times(1)).saveOrder(co);
    }
}
