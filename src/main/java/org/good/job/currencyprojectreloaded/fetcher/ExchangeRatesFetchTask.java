package org.good.job.currencyprojectreloaded.fetcher;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRatesListDto;
import org.good.job.currencyprojectreloaded.entity.EndpointData;
import org.good.job.currencyprojectreloaded.exception.ExchangeRateLoadingFailureException;
import org.good.job.currencyprojectreloaded.fetcher.impl.ExchangeRateFetcherImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
public class ExchangeRatesFetchTask implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(ExchangeRateFetcherImpl.class);
    private final FetchTaskDependenciesData dependenciesData;
    private final EndpointData endpointData;
    @Value("${cpr.log.message.fetcher.not-fetch }")
    private String currencyRatesNotFetchLogMessage;

    @Override
    public void run() {
        try {
            ExternalExchangeRatesListDto exchangeRatesListDto = dependenciesData.getFetcherRestClient()
                    .get()
                    .uri(endpointData.getUrl())
                    .accept(APPLICATION_JSON)
                    .exchange(dependenciesData.getExchangeRateExtractor()::extract);
            long exchangeRateSourceId = endpointData.getExchangeRateSource().getId();
            exchangeRatesListDto.setExchangeRateSourceId(exchangeRateSourceId);
            dependenciesData.getExchangeRateService().save(exchangeRatesListDto);
        } catch (ExchangeRateLoadingFailureException e) {
            logger.error(currencyRatesNotFetchLogMessage, endpointData.getExchangeRateSource());
        }
    }

}
