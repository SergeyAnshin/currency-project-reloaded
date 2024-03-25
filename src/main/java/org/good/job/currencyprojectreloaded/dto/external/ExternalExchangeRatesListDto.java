package org.good.job.currencyprojectreloaded.dto.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ExternalExchangeRatesListDto {
    @JsonAlias({ "rates" })
    private List<ExternalExchangeRateDto> exchangeRates;
    @JsonIgnore
    private long exchangeRateSourceId;

}
