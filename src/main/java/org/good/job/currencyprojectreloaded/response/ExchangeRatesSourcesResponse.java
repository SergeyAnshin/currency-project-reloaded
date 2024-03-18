package org.good.job.currencyprojectreloaded.response;

import lombok.*;
import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceDto;
import org.good.job.currencyprojectreloaded.dto.PageData;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ExchangeRatesSourcesResponse {
    private List<ExchangeRateSourceDto> exchangeRateSources;
    private PageData pageData;

}
