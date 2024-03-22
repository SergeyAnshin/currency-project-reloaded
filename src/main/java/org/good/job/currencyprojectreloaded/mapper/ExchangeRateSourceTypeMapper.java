package org.good.job.currencyprojectreloaded.mapper;

import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceTypeDto;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSourceType;
import org.mapstruct.Mapper;

@Mapper
public interface ExchangeRateSourceTypeMapper {

    ExchangeRateSourceTypeDto toExchangeRateSourceTypeDto(ExchangeRateSourceType exchangeRateSourceType);

}
