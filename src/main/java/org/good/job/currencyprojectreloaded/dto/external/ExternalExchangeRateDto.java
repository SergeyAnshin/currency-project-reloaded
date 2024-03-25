package org.good.job.currencyprojectreloaded.dto.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.good.job.currencyprojectreloaded.dto.deserializer.CustomLocalDateTimeDeserializer;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ExternalExchangeRateDto {
    @JsonAlias({ "sellIso" })
    private String sellAlphabeticCurrencyCode;
    @JsonAlias({ "buyIso" })
    private String buyAlphabeticCurrencyCode;
    @JsonAlias({ "sellRate" })
    private double sellRate;
    @JsonAlias({ "buyRate" })
    private double buyRate;
    @JsonAlias({ "quantity" })
    private double currencyDenomination;
    @JsonAlias({ "date" })
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime rateDateTime;

}
