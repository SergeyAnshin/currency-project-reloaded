package org.good.job.currencyprojectreloaded.service.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRateDto;
import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRatesListDto;
import org.good.job.currencyprojectreloaded.entity.ExchangeRate;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.good.job.currencyprojectreloaded.fetcher.impl.ExchangeRateFetcherImpl;
import org.good.job.currencyprojectreloaded.mapper.ExchangeRateMapper;
import org.good.job.currencyprojectreloaded.repository.ExchangeRateRepository;
import org.good.job.currencyprojectreloaded.service.ExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final Logger logger = LoggerFactory.getLogger(ExchangeRateFetcherImpl.class);
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    @Value("${cpr.log.message.exchange-rate-service.existing-exchange-rate}")
    private String existingExchangeRateLogMessage;

    @Override
    public List<ExchangeRate> save(ExternalExchangeRatesListDto exchangeRatesListDto) {
        List<ExternalExchangeRateDto> exchangeRateDtoList = exchangeRatesListDto.getExchangeRates();
        List<ExchangeRate> exchangeRates = exchangeRateMapper.toExchangeRateList(exchangeRateDtoList);
        ExchangeRateSource exchangeRateSource = ExchangeRateSource.builder()
                .id(exchangeRatesListDto.getExchangeRateSourceId()).build();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id");
        Predicate<ExchangeRate> notExistingExchangeRate = (exchangeRate) -> {
            if (exchangeRateRepository.exists(Example.of(exchangeRate, exampleMatcher))) {
                logger.warn(existingExchangeRateLogMessage, exchangeRate);
                return false;
            }
            return true;
        };
        List<ExchangeRate> exchangeRatesToSave = exchangeRates.stream()
                .peek(exchangeRate -> exchangeRate.setExchangeRateSource(exchangeRateSource))
                .filter(notExistingExchangeRate)
                .toList();
        return exchangeRateRepository.saveAll(exchangeRatesToSave);
    }

}
