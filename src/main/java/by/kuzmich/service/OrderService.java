package by.kuzmich.service;

import by.kuzmich.domain.Order;
import by.kuzmich.domain.OrderStatus;
import by.kuzmich.persistance.OrderStorage;
import by.kuzmich.service.validator.OrderValidator;
import by.kuzmich.service.validator.UserIdValidator;

import java.util.List;

public class OrderService {

    private final OrderStorage orderStorage;

    private final OrderValidator orderValidator;

    private final UserIdValidator userIdValidator;

    public OrderService(OrderStorage orderStorage, OrderValidator orderValidator, UserIdValidator userIdValidator) {
        this.orderStorage = orderStorage;
        this.orderValidator = orderValidator;
        this.userIdValidator = userIdValidator;
    }

    public List<Order> loadAllByUserID(String userId) {
        if (!userIdValidator.validate(userId)) {
            throw new IllegalArgumentException("userId is not valid " + userId);
        }

        return orderStorage.loadAllByUserID(userId);
    }

    public String placeOrder(Order order) {

        final boolean valid = orderValidator.validateForCreationOrder(order);
        if (!valid) {
            throw new IllegalArgumentException("order is not valid " + order);
        }

        order.setStatus(OrderStatus.INITIAL);

        return orderStorage.persist(order);

    }
}
