package by.kuzmich.persistance;

import by.kuzmich.domain.OrderItem;

import java.util.Optional;

public class OrderItemStorage {

    public Optional<OrderItem> findByOrderItemName(String orderItemName) {
        return Optional.empty();
    }

    public static String persist(OrderItem orderItem) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public static OrderItem load(String id) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
