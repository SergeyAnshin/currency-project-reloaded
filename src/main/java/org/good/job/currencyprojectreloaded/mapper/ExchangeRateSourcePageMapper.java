package org.good.job.currencyprojectreloaded.mapper;

import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceDto;
import org.good.job.currencyprojectreloaded.response.ExchangeRatesSourcesResponse;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(uses = { PageableMapper.class })
public interface ExchangeRateSourcePageMapper {

    @Mapping(target = "exchangeRateSources", source = "content")
    @Mapping(target = "pageData", source = ".")
    ExchangeRatesSourcesResponse toExchangeRatesSourcesResponse(Page<ExchangeRateSource> exchangeRateSourcePage);

    List<ExchangeRateSourceDto> toExchangeRateSourceDto(List<ExchangeRateSource> exchangeRateSource);

    ExchangeRateSourceDto toExchangeRateSourceDto(ExchangeRateSource exchangeRateSource);

}
