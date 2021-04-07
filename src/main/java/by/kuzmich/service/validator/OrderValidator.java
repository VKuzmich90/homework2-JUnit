package by.kuzmich.service.validator;

import by.kuzmich.domain.Order;
import by.kuzmich.persistance.OrderStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OrderValidator {

    Logger logger = LoggerFactory.getLogger(OrderValidator.class);

    public boolean validateForCreationOrder(Order order) {

        if (order.getId() == null) {
            logger.debug("The entered orderId is incorrect");
            return false;
        }

        if (order.getUserId() == null) {
            logger.debug("The entered userId is incorrect");
            return false;
        }

        if (order.getItems() == null) {
            logger.debug("The entered items are incorrect");
            return false;
        }

        if (order.getDate() == null) {
            logger.debug("The entered date is incorrect");
            return false;
        }

        if (order.getDeliveryAdress() == null) {
            logger.debug("The entered adress is incorrect");
            return false;
        }

        return true;
    }

    public boolean validateForFindByOrderId(Order order, OrderStorage orderStorage) {
        Optional<Order> byOrderId = orderStorage.findByOrderId(order.getId());

        if (byOrderId.isEmpty()) {
            logger.debug("The orderId is empty");
        }

        return true;
    }

}
