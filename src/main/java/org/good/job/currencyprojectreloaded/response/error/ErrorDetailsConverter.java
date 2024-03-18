package org.good.job.currencyprojectreloaded.response.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

public interface ErrorDetailsConverter {

    ProblemDetail convert(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request);

}
