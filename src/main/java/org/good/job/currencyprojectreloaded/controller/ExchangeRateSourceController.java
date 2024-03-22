package org.good.job.currencyprojectreloaded.controller;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.dto.ExchangeRatesSourcesDto;
import org.good.job.currencyprojectreloaded.dto.RequestParametersData;
import org.good.job.currencyprojectreloaded.response.ExchangeRatesSourcesResponse;
import org.good.job.currencyprojectreloaded.response.assembler.ExchangeRatesSourcesResponseModelAssembler;
import org.good.job.currencyprojectreloaded.service.impl.ExchangeRateSourceService;
import org.good.job.currencyprojectreloaded.validator.PageCheck;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/exchange-rate-sources")
public class ExchangeRateSourceController {
    private final ExchangeRateSourceService exchangeRateSourceService;
    private final ExchangeRatesSourcesResponseModelAssembler exchangeRatesSourcesResponseModelAssembler;

    @GetMapping
    public ResponseEntity<?> getAllExchangeRateSources(
            @Validated(PageCheck.class) RequestParametersData requestParametersData) {
        ExchangeRatesSourcesDto exchangeRatesSourcesDto = exchangeRateSourceService.getExchangeRateSources(
                requestParametersData);
        EntityModel<ExchangeRatesSourcesResponse> entityModel = exchangeRatesSourcesResponseModelAssembler.toModel(
                exchangeRatesSourcesDto);
        return ResponseEntity.ok(entityModel);
    }

}
