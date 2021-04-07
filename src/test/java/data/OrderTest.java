package data;

import by.kuzmich.domain.Order;
import by.kuzmich.domain.OrderItem;
import by.kuzmich.domain.OrderStatus;


public class OrderTest {

    public static Order anyValidOrder() {
        return validOrder("1111");
    }

    public static Order validOrder(String id) {
        Order order = new Order("1111", "2222");
        order.setStatus(OrderStatus.INITIAL);
        order.setDeliveryAdress("Minsk, Surganova 43-7");
        order.setItems(new OrderItem[]{new OrderItem("11"), new OrderItem("22")});

        return order;
    }
}
