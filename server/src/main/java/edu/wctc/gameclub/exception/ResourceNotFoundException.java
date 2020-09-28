package edu.wctc.gameclub.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String resource, String param, String value) {
        super(String.format("%s not found for %s: %s", resource, param, value));
    }

    public ResourceNotFoundException(String event, String param, int value) {
        this(event, param, Integer.toString(value));
    }
}
