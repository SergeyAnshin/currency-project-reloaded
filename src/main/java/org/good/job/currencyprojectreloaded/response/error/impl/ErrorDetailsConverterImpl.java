package org.good.job.currencyprojectreloaded.response.error.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.response.error.ErrorDetailsConverter;
import org.good.job.currencyprojectreloaded.response.error.ObjectFieldError;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor

@Component
public class ErrorDetailsConverterImpl implements ErrorDetailsConverter {
    public static final String CPR_VALIDATION_400_TITLE = "cpr.validation.400.title";
    public static final String CPR_VALIDATION_400_DETAIL = "cpr.validation.400.detail";
    public static final String ERRORS = "errors";
    private final MessageSource messageSource;

    @Override
    public ProblemDetail convert(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request) {
        String title = messageSource.getMessage(CPR_VALIDATION_400_TITLE, null, request.getLocale());
        String detail = messageSource.getMessage(CPR_VALIDATION_400_DETAIL, null, request.getLocale());
        String uri = ((ServletWebRequest) request).getRequest().getRequestURI();
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle(title);
        problemDetail.setDetail(detail);
        problemDetail.setProperty(ERRORS, convertToObjectFieldError(ex.getFieldErrors()));
        problemDetail.setInstance(URI.create(uri));
        return problemDetail;
    }

    private List<ObjectFieldError> convertToObjectFieldError(List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(ObjectFieldError::new).toList();
    }

}
