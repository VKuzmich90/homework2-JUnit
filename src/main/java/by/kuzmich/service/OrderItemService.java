package by.kuzmich.service;

import by.kuzmich.domain.OrderItem;
import by.kuzmich.persistance.OrderItemStorage;
import by.kuzmich.service.validator.OrderItemValidator;

public class OrderItemService {

    private final OrderItemStorage orderItemStorage;

    private final OrderItemValidator orderItemValidator;

    public OrderItemService(OrderItemStorage orderItemStorage, OrderItemValidator orderItemValidator) {
        this.orderItemStorage = orderItemStorage;
        this.orderItemValidator = orderItemValidator;
    }

    public String createOrderItem(OrderItem orderItem) {

        final boolean valid = orderItemValidator.validateForCreationOrderItem(orderItem);
        if (!valid) {
            throw new IllegalArgumentException("orderItem is not valid " + orderItem);
        }

        return orderItemStorage.persist(orderItem);

    }
}