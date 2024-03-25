package org.good.job.currencyprojectreloaded.exception;

import java.io.IOException;

public class ExchangeRateLoadingFailureException extends RuntimeException {

    public ExchangeRateLoadingFailureException() {
    }

    public ExchangeRateLoadingFailureException(IOException e) {}

}
