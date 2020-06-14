package com.shoppingcart.ShoppingCart.dto;

import com.shoppingcart.ShoppingCart.entity.Product;

import java.util.List;

public class ProductCollectionDTO {

    private List<Product> productList;

    public ProductCollectionDTO(List<Product> productList){
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
