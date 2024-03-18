package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRate {
    @Id
    @GeneratedValue
    private long id;
    private String sellAlphabeticCurrencyCode;
    private String buyAlphabeticCurrencyCode;
    private double sellRate;
    private double buyRate;
    private LocalDateTime rateDateTime;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exchange_rate_source_id", nullable = false, updatable = false)
    private ExchangeRateSource exchangeRateSource;

}
