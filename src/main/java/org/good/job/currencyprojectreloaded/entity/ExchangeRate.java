package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRate extends GeneralEntity {
    private String sellAlphabeticCurrencyCode;
    private String buyAlphabeticCurrencyCode;
    private double sellRate;
    private double buyRate;
    private double currencyDenomination;
    private LocalDateTime rateDateTime;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exchange_rate_source_id", nullable = false, updatable = false)
    private ExchangeRateSource exchangeRateSource;

}
