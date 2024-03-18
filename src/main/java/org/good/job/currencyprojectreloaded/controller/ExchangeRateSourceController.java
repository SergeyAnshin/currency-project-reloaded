package org.good.job.currencyprojectreloaded.controller;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.response.ExchangeRatesSourcesResponse;
import org.good.job.currencyprojectreloaded.dto.RequestParametersData;
import org.good.job.currencyprojectreloaded.service.impl.ExchangeRateSourceService;
import org.good.job.currencyprojectreloaded.validator.PageCheck;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
// available-exchange-rate-sources
@RestController
public class ExchangeRateSourceController {
    public static final String GET_EXCHANGE_RATE_SOURCES_URL = "/exchange-rate-sources";
    private final ExchangeRateSourceService exchangeRateSourceService;

    @GetMapping(GET_EXCHANGE_RATE_SOURCES_URL)
    public ResponseEntity<EntityModel<ExchangeRatesSourcesResponse>> getExchangeRateSources(
            @Validated(PageCheck.class) RequestParametersData requestParametersData) {
        ExchangeRatesSourcesResponse exchangeRateSources = exchangeRateSourceService.getExchangeRateSources(
                requestParametersData);
        return ResponseEntity.ok(EntityModel.of(exchangeRateSources));
    }

}
