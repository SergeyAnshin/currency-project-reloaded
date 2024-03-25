package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRateSource extends GeneralEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "exchange_rate_source_type_id", nullable = false, updatable = false)
    private ExchangeRateSourceType exchangeRateSourceType;
    private String name;
    @OneToOne(optional = false)
    @JoinColumn(name = "endpoint_data_id", unique = true, nullable = false, updatable = false)
    private EndpointData endpointData;

}
