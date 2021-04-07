package by.kuzmich.persistance;

import by.kuzmich.domain.Order;
import org.junit.jupiter.api.Test;

import static data.OrderTest.anyValidOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderStorageTest {

    private OrderStorage orderStorage = new OrderStorage();


    @Test
    public void testPersist() {
        Order order = anyValidOrder();

        final String id = orderStorage.persist(order);

        assertThat("id is generated", id, is(not(null)));
        final Order loaded = OrderStorage.load(id);
        assertThat(loaded, is(equalTo(order)));
    }

    @Test
    public void testPersist_null() {

        assertThrows(NullPointerException.class, () -> OrderStorage.persist(null));
    }

}