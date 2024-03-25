package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter

@Entity
public class EndpointData extends GeneralEntity {
    private String url;
    @OneToOne(optional = false, mappedBy = "endpointData")
    private ExchangeRateSource exchangeRateSource;

    @Override
    public String toString() {
        return "EndpointData{" +
                "url='" + url + '\'' +
                "} " + super.toString();
    }

}
