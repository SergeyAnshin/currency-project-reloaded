package org.good.job.currencyprojectreloaded.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ExchangeRateSourceDto {
    private long id;
    private ExchangeRateSourceTypeDto exchangeRateSourceType;
    private String name;

}
