package com.shoppingcart.ShoppingCart.rest;

import com.shoppingcart.ShoppingCart.ShoppingCartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplication.class)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class ShoppingCartControllerE2E {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateOrder() throws Exception {
        mockMvc.perform(post("/cart/orders")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"orderProducts\": [ " +
                        "{\"name\":\"spoon\",\"price\":10.0,\"quantity\":3}, " +
                        "{\"name\":\"fridge\",\"price\":1000.0,\"quantity\":1}]}")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void shouldGetProducts() throws Exception
    {
        mockMvc.perform(
                MockMvcRequestBuilders
                .get("/cart/products")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productList").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productList[*].name").isNotEmpty());;
    }
}
