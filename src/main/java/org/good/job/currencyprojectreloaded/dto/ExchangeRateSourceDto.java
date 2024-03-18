package org.good.job.currencyprojectreloaded.dto;

import lombok.*;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSourceType;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ExchangeRateSourceDto {
    private long id;
    private ExchangeRateSourceType exchangeRateSourceType;
    private String name;

}
