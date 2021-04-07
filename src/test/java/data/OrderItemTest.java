package data;

import by.kuzmich.domain.OrderItem;

public class OrderItemTest {

    public static OrderItem anyValidOrderItem() {
        return validOrderItem("Vasya");
    }

   public static OrderItem validOrderItem(String name) {
        OrderItem orderItem = new OrderItem("Kyzya");
        orderItem.setNumber(2);
        orderItem.setCost(10);


        return orderItem;
    }

}
