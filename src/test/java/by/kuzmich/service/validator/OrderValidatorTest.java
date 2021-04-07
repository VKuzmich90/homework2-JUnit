package by.kuzmich.service.validator;

import by.kuzmich.domain.Order;
import org.junit.jupiter.api.Test;

import static data.OrderTest.anyValidOrder;
import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    @Test
    public void testValidator_null() {

        Order order = anyValidOrder();

        assertNotNull(order.getId());
        assertNotNull(order.getUserId());
        assertNotNull(order.getItems());
        assertNotNull(order.getDeliveryAdress());

    }

}