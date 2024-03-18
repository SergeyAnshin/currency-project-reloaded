package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRateSource {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exchange_rate_source_type_id", nullable = false, updatable = false)
    private ExchangeRateSourceType exchangeRateSourceType;
    private String name;

}
