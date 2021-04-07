package by.kuzmich.service.validator;

import by.kuzmich.domain.OrderItem;
import by.kuzmich.persistance.OrderItemStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OrderItemValidator {

    Logger logger = LoggerFactory.getLogger(OrderItemValidator.class);

    public boolean validateForCreationOrderItem(OrderItem orderItem) {

        if (orderItem.getName() == null) {
            logger.debug("The entered orderName is incorrect");
            return false;
        }

        if (orderItem.getId() == null) {
            logger.debug("The entered orderItemId is incorrect");
            return false;
        }

        if (orderItem.getCost() <= 0) {
            logger.debug("The entered orderItemCost is incorrect");
            return false;
        }

        if (orderItem.getNumber() <= 0) {
            logger.debug("The entered orderItemNumber is incorrect");
            return false;
        }

        return true;
    }

    public boolean validateForFindByOrderId(OrderItem orderItem, OrderItemStorage orderItemStorage) {
        Optional<OrderItem> byOrderItemName = orderItemStorage.findByOrderItemName(orderItem.getName());

        if (byOrderItemName.isEmpty()) {
            logger.debug("The orderItemName is empty");
        }

        return true;
    }

}
