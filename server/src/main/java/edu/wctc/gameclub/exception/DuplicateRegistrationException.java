package edu.wctc.gameclub.exception;

public class DuplicateRegistrationException extends RuntimeException {
    public DuplicateRegistrationException(String email, String event) {
        super(String.format("Member %s is already registered for %s", email, event));
    }
}
