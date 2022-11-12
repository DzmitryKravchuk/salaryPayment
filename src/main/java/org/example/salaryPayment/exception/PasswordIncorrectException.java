package org.example.salaryPayment.exception;

public class PasswordIncorrectException extends AbstractBusinessException{

    private static final long serialVersionUID = -5353437146391403109L;

    public PasswordIncorrectException(String message) {
        super(message);
    }
}
