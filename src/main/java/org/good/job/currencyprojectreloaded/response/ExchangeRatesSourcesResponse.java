package org.good.job.currencyprojectreloaded.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceDto;
import org.good.job.currencyprojectreloaded.dto.PageData;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ExchangeRatesSourcesResponse {
    @JsonUnwrapped
    private CollectionModel<EntityModel<ExchangeRateSourceDto>> exchangeRateSources;
    private PageData pageData;

}
