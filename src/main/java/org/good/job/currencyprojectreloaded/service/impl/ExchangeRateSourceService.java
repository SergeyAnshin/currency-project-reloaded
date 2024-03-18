package org.good.job.currencyprojectreloaded.service.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.dto.RequestParametersData;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.good.job.currencyprojectreloaded.mapper.ExchangeRateSourcePageMapper;
import org.good.job.currencyprojectreloaded.mapper.PageableMapper;
import org.good.job.currencyprojectreloaded.repository.ExchangeRateSourceRepository;
import org.good.job.currencyprojectreloaded.response.ExchangeRatesSourcesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class ExchangeRateSourceService {
    private final ExchangeRateSourceRepository exchangeRateSourceRepository;
    private final PageableMapper pageableMapper;
    private final ExchangeRateSourcePageMapper exchangeRateSourcePageMapper;

    public ExchangeRatesSourcesResponse getExchangeRateSources(RequestParametersData requestParametersData) {
        Pageable mappedPageData = pageableMapper.toPageable(requestParametersData.getPageData());
        Page<ExchangeRateSource> exchangeRateSourcePage = exchangeRateSourceRepository.findAll(mappedPageData);
        ExchangeRatesSourcesResponse exchangeRatesSourcesResponse
                = exchangeRateSourcePageMapper.toExchangeRatesSourcesResponse(exchangeRateSourcePage);
        return exchangeRatesSourcesResponse;
    }

}
