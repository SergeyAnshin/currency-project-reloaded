package org.good.job.currencyprojectreloaded.service;

import org.good.job.currencyprojectreloaded.dto.ExchangeRatesSourcesDto;
import org.good.job.currencyprojectreloaded.dto.RequestParametersData;

public interface ExchangeRateSourceService {

    ExchangeRatesSourcesDto getExchangeRateSources(RequestParametersData requestParametersData);

}
