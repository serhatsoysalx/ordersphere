package com.ordersphere.ordersphere.util.expections;

import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException() {
        super(LoginErrorMessage.USER_ALREADY_EXISTS);
    }
}

