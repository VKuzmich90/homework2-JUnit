package by.kuzmich.service;

import by.kuzmich.domain.OrderItem;
import by.kuzmich.persistance.OrderItemStorage;
import by.kuzmich.service.validator.OrderItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static data.OrderItemTest.anyValidOrderItem;
import static data.OrderItemTest.validOrderItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class OrderItemServiceTest {

    private OrderItemService orderItemService;

    @Mock
    private OrderItemValidator orderItemValidator;

    @Mock
    private OrderItemStorage orderItemStorage;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);

        when(orderItemStorage.persist(any())).thenReturn(UUID.randomUUID().toString());

        orderItemService = new OrderItemService(orderItemStorage, orderItemValidator);
    }

    @Test
    void createOrderItem_invalid() {
        //given
        OrderItem orderItem = anyValidOrderItem();
        orderItemIsValid(orderItem);

        //expect
        assertThrows(IllegalArgumentException.class, () -> orderItemService.createOrderItem(orderItem));
        verify(orderItemStorage, never()).persist(any());
    }

    @Test
    void createOrderItem_OrderItemNameIsBusy() {
        //given
        String orderItemName = "busy_name";
        when(orderItemStorage.findByOrderItemName(orderItemName)).thenReturn(Optional.of(anyValidOrderItem()));

        OrderItem orderItem = validOrderItem(orderItemName);
        when(orderItemValidator.validateForCreationOrderItem(orderItem)).thenReturn(true);

        //expect
        assertThrows(IllegalStateException.class, () -> orderItemService.createOrderItem(orderItem));
        verify(orderItemStorage, never()).persist(any());
    }

    @Test
    void createOrderItem() {
        //given
        String orderItemName = "name";
        //no orderItem name in storage
        when(orderItemStorage.findByOrderItemName(orderItemName)).thenReturn(Optional.empty());

        OrderItem orderItem = validOrderItem(orderItemName);
        when(orderItemValidator.validateForCreationOrderItem(orderItem)).thenReturn(true);

        //when
        final String id = orderItemService.createOrderItem(orderItem);

        //then
        assertNotNull(id);
        verify(orderItemStorage).persist(orderItem);

    }

    void orderItemIsValid(OrderItem orderItem) {
        when(orderItemValidator.validateForCreationOrderItem(orderItem)).thenReturn(false);
    }
}