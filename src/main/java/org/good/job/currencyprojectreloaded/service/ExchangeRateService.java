package org.good.job.currencyprojectreloaded.service;

import org.good.job.currencyprojectreloaded.dto.external.ExternalExchangeRatesListDto;
import org.good.job.currencyprojectreloaded.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateService {

    List<ExchangeRate> save(ExternalExchangeRatesListDto exchangeRates);

}
