package org.good.job.currencyprojectreloaded.fetcher.impl;

import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRatesListDto;
import org.good.job.currencyprojectreloaded.exception.ExchangeRateLoadingFailureException;
import org.good.job.currencyprojectreloaded.fetcher.ExternalExchangeRateExtractor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.io.IOException;

import static java.util.Objects.nonNull;

@Component
public class ExternalExchangeRateExtractorImpl implements ExternalExchangeRateExtractor {

    @Override
    public ExternalExchangeRatesListDto extract(HttpRequest request,
            RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse response)
            throws ExchangeRateLoadingFailureException {
        try {
            HttpStatusCode statusCode = response.getStatusCode();
            if (statusCode.is2xxSuccessful()) {
                ExternalExchangeRatesListDto exchangeRatesListDto = response.bodyTo(ExternalExchangeRatesListDto.class);
                if (nonNull(exchangeRatesListDto)) {
                    return exchangeRatesListDto;
                }
            }
            throw new ExchangeRateLoadingFailureException();
        } catch (IOException e) {
            throw new ExchangeRateLoadingFailureException();
        }
    }

}
