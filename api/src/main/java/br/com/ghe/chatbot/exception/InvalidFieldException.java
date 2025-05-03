package br.com.ghe.chatbot.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class InvalidFieldException extends ResponseStatusException {
    public InvalidFieldException(String message) {
        super(BAD_REQUEST, message);
    }
}
