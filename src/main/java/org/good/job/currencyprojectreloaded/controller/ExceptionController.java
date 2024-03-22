package org.good.job.currencyprojectreloaded.controller;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.response.error.AppErrorResponse;
import org.good.job.currencyprojectreloaded.response.error.AppErrorResponseGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequiredArgsConstructor

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    private final AppErrorResponseGenerator appErrorResponseGenerator;

    // TODO Custom validation message for TypeMismatchException
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        AppErrorResponse appErrorResponse = appErrorResponseGenerator.generate(ex, headers, status, request);
        return ResponseEntity.badRequest().body(appErrorResponse);
    }

}
