package org.good.job.currencyprojectreloaded.service.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.dto.ExchangeRatesSourcesDto;
import org.good.job.currencyprojectreloaded.dto.RequestParametersData;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.good.job.currencyprojectreloaded.mapper.ExchangeRateSourceMapper;
import org.good.job.currencyprojectreloaded.mapper.PageableMapper;
import org.good.job.currencyprojectreloaded.repository.ExchangeRateSourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class ExchangeRateSourceService {
    private final ExchangeRateSourceRepository exchangeRateSourceRepository;
    private final PageableMapper pageableMapper;
    private final ExchangeRateSourceMapper exchangeRateSourceMapper;

    public ExchangeRatesSourcesDto getExchangeRateSources(RequestParametersData requestParametersData) {
        Pageable mappedPageData = pageableMapper.toPageable(requestParametersData.getPageData());
        Page<ExchangeRateSource> exchangeRateSourcePage = exchangeRateSourceRepository.findAll(mappedPageData);
        ExchangeRatesSourcesDto exchangeRatesSourcesDto
                = exchangeRateSourceMapper.toExchangeRatesSourcesResponse(exchangeRateSourcePage);
        return exchangeRatesSourcesDto;
    }

}
