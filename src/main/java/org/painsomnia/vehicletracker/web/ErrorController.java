package org.painsomnia.vehicletracker.web;

import org.painsomnia.vehicletracker.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorDto> handleException(RuntimeException exception) {
        final List<String> stacktrace = Arrays.stream(exception.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.toList());
        final ErrorDto error = new ErrorDto(exception.getMessage(), stacktrace);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
