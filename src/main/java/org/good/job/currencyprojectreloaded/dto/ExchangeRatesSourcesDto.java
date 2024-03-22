package org.good.job.currencyprojectreloaded.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ExchangeRatesSourcesDto {
    private List<ExchangeRateSourceDto> exchangeRateSources;
    private PageData pageData;

}
