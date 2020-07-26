package com.legalmatch.exam.controller.advice;

import com.legalmatch.exam.dto.Error;
import com.legalmatch.exam.dto.ErrorsDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.enums.Severity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class ApplicationExceptionHandler {

    // error handle for @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorsDto>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {
        log.info("**** handleMethodArgumentNotValid ***");
        return new ResponseEntity<>(
                ErrorsDto.builder()
                    .errors(ex.getBindingResult()
                            .getFieldErrors()
                            .stream()
                            .map(e -> Error.builder()
                                    .code(ResponseCode.BAD_REQUEST)
                                    .attribute(e.getField())
                                    .message("error in " + e.getField())
                                    .severity(Severity.ERROR)
                                    .timestamp(LocalDateTime.now())
                                    .build())
                            .collect(Collectors.toList()))
                    .build(),
                HttpStatus.BAD_REQUEST
        );

    }

    // error handle for constraint violation
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorsDto>
    handleConstraintViolationException(ConstraintViolationException ex){
        log.info("**** handleConstraintViolationException ***");
        return new ResponseEntity<>(
                ErrorsDto.builder()
                        .errors(ex.getConstraintViolations()
                                .stream()
                                .map(e -> Error.builder()
                                        .code(ResponseCode.BAD_REQUEST)
                                        .attribute(e.getRootBeanClass().getSimpleName()+"."+e.getPropertyPath().toString())
                                        .message(e.getMessage())
                                        .severity(Severity.ERROR)
                                        .timestamp(LocalDateTime.now())
                                        .build())
                                .collect(Collectors.toList()))
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
