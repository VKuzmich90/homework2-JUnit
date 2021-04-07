package by.kuzmich.service;

import by.kuzmich.domain.Order;
import by.kuzmich.persistance.OrderStorage;
import by.kuzmich.service.validator.OrderValidator;
import by.kuzmich.service.validator.UserIdValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static data.OrderTest.anyValidOrder;
import static data.OrderTest.validOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private UserIdValidator userIdValidator;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);

        when(orderStorage.persist(any())).thenReturn(UUID.randomUUID().toString());

        orderService = new OrderService(orderStorage, orderValidator, userIdValidator);
    }

    @Test
    void createOrder_invalid() {
        //given
        Order order = anyValidOrder();
        orderIsValid(order);

        //expect
        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).persist(any());
    }

    @Test
    void createOrder_OrderIdIsBusy() {
        //given
        String orderId = "busy_Id";
        when(orderStorage.findByOrderId(orderId)).thenReturn(Optional.of(anyValidOrder()));

        Order order = validOrder(orderId);
        when(orderValidator.validateForCreationOrder(order)).thenReturn(true);

        //expect
        assertThrows(IllegalStateException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).persist(any());
    }

    @Test
    void createOrder() {
        //given
        String orderId = "orderId";
        //no orderId name in storage
        when(orderStorage.findByOrderId(orderId)).thenReturn(Optional.empty());

        Order order = validOrder(orderId);
        when(orderValidator.validateForCreationOrder(order)).thenReturn(true);

        //when
        final String id = orderService.placeOrder(order);

        //then
        assertNotNull(id);
        verify(orderStorage).persist(order);

    }

    void orderIsValid(Order order) {
        when(orderValidator.validateForCreationOrder(order)).thenReturn(false);
    }
}
