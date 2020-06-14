package service;

import com.shoppingcart.ShoppingCart.dto.CustomerOrderDTO;
import com.shoppingcart.ShoppingCart.entity.OrderProduct;
import com.shoppingcart.ShoppingCart.repository.OrderRepository;
import com.shoppingcart.ShoppingCart.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Before
    public void before(){
        orderService = new OrderService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveOrderCallsOrderRepository(){
        //Given
        OrderProduct op1 = new OrderProduct("Spoon", 25.0, 10);
        OrderProduct op2 = new OrderProduct("Car", 2500.0, 1);
        List<OrderProduct> products = new ArrayList<>();
        products.add(op1);
        products.add(op2);

        CustomerOrderDTO cod = new CustomerOrderDTO(products);

        //Invocation
        orderService.saveOrder(cod);

        //Assertions
        Mockito.verify(orderRepository, Mockito.times(1)).save(Mockito.any());
    }
}
