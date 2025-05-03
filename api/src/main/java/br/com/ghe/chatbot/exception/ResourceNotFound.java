package br.com.ghe.chatbot.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ResourceNotFound extends ResponseStatusException {
    public ResourceNotFound(String message) {
        super(NOT_FOUND, message);
    }
}
