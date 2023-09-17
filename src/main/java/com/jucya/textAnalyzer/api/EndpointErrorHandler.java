package com.jucya.textAnalyzer.api;

import com.jucya.textAnalyzer.api.shared.ErrorDescription;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обрабатывает ошибки приложения.
 *
 * @since 0.1
 */
@RestControllerAdvice
class EndpointErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ErrorDescription handleRequiredFieldNotNull() {
        return new ErrorDescription("Ошибка. Значение не должно быть пустым.");
    }
}
