package org.good.job.currencyprojectreloaded.fetcher;

import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRatesListDto;
import org.good.job.currencyprojectreloaded.exception.ExchangeRateLoadingFailureException;
import org.springframework.http.HttpRequest;
import org.springframework.web.client.RestClient;

public interface ExternalExchangeRateExtractor {

    ExternalExchangeRatesListDto extract(HttpRequest request,
            RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse response)
            throws ExchangeRateLoadingFailureException;

}
