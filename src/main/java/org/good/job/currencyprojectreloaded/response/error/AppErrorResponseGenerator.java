package org.good.job.currencyprojectreloaded.response.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

public interface AppErrorResponseGenerator {

    AppErrorResponse generate(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request);

}
