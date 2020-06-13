package dto;

import com.shoppingcart.ShoppingCart.entity.Product;

import java.util.List;

public class ProductCollection {

    private List<Product> productList;

    public ProductCollection(List<Product> productList){
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
