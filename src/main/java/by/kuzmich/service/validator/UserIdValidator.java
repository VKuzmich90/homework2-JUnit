package by.kuzmich.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIdValidator {

    Logger logger = LoggerFactory.getLogger(UserIdValidator.class);

    public boolean validate(String userId) {
        if (userId == null || userId.length() == 0) {
            logger.debug("The entered userIf is incorrect");
            return false;
        }

        return true;
    }
}
