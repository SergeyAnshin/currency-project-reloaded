package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRateSourceType {
    @Id
    @GeneratedValue
    private long id;
    private String name;

}
