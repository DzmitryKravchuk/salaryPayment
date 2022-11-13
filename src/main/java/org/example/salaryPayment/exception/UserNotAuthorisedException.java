package org.example.salaryPayment.exception;

public class UserNotAuthorisedException extends AbstractBusinessException{
    private static final long serialVersionUID = -1671165167110467939L;

    public UserNotAuthorisedException(String message) {
        super(message);
    }
}
