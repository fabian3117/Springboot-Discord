package com.example.discord_webhook.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class HandleException {
    Logger logger = LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(RuntimeException e) {
        logger.error(e.getMessage());
    }

}
