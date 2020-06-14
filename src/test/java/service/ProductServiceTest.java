package service;

import com.shoppingcart.ShoppingCart.dto.ProductCollectionDTO;
import com.shoppingcart.ShoppingCart.entity.Product;
import com.shoppingcart.ShoppingCart.repository.ProductRepository;
import com.shoppingcart.ShoppingCart.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void before(){
        productService = new ProductService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProductsCallsFindAllAndReturnsProductCollectionDTO(){
        //Given
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product("Spoon", 4.0);
        Product p2 = new Product("Book", 15.0);
        productList.add(p1);
        productList.add(p2);

        //When
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        //Invocation
        ProductCollectionDTO result = productService.getAllProducts();

        //Assertions
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
        Assert.assertEquals(result.getProductList(), productList);
    }

    @Test
    public void saveProductCallsProductRepository(){
        //Given
        Product p = new Product("Spoon", 600.0);

        //Invocation
        productService.saveProduct(p);

        //Assertions
        Mockito.verify(productRepository, Mockito.times(1)).save(p);
    }
}
