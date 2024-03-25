package org.good.job.currencyprojectreloaded.fetcher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.service.ExchangeRateService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Getter

@Component
public class FetchTaskDependenciesData {
    private final RestClient fetcherRestClient;
    private final ExternalExchangeRateExtractor exchangeRateExtractor;
    private final ExchangeRateService exchangeRateService;

}
