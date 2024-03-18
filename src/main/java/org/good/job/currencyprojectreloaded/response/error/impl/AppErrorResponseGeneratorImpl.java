package org.good.job.currencyprojectreloaded.response.error.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.response.error.AppErrorResponse;
import org.good.job.currencyprojectreloaded.response.error.AppErrorResponseGenerator;
import org.good.job.currencyprojectreloaded.response.error.ErrorDetailsConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

@RequiredArgsConstructor

@Component
public class AppErrorResponseGeneratorImpl implements AppErrorResponseGenerator {
    private final ErrorDetailsConverter errorDetailsConverter;

    @Override
    public AppErrorResponse generate(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request) {
        ProblemDetail problemDetail = errorDetailsConverter.convert(ex, headers, status, request);
        return AppErrorResponse.builder().problemDetail(problemDetail).build();
    }

}
