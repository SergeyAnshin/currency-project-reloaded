package org.good.job.currencyprojectreloaded.mapper;

import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRateDto;
import org.good.job.currencyprojectreloaded.entity.ExchangeRate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExchangeRateMapper {

    List<ExchangeRate> toExchangeRateList(List<ExternalExchangeRateDto> exchangeRateDtoList);

    ExchangeRate toExchangeRate(ExternalExchangeRateDto exchangeRateDto);

}
