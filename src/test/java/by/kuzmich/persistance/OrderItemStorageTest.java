package by.kuzmich.persistance;

import by.kuzmich.domain.OrderItem;
import org.junit.jupiter.api.Test;

import static data.OrderItemTest.anyValidOrderItem;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemStorageTest {

    private OrderItemStorage orderItemStorage = new OrderItemStorage();


    @Test
    public void testPersist() {
        OrderItem orderItem = anyValidOrderItem();

        final String id = orderItemStorage.persist(orderItem);

        assertThat("id is generated", id, is(not(null)));
        final OrderItem loaded = OrderItemStorage.load(id);
        assertThat(loaded, is(equalTo(orderItem)));
    }

    @Test
    public void testPersist_null() {
        assertThrows(NullPointerException.class, () -> OrderItemStorage.persist(null));
    }


}