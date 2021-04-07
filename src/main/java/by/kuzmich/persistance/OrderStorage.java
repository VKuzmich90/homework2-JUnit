package by.kuzmich.persistance;

import by.kuzmich.domain.Order;

import java.util.List;
import java.util.Optional;

public class OrderStorage {
    public Optional<Order> findByOrderId(String orderId) {
        return Optional.empty();
    }

    public static String persist(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public static Order load(String id) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public List<Order> loadAllByUserID(String userId) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}

