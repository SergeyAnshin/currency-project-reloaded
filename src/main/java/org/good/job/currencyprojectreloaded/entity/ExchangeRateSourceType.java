package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString

@Entity
public class ExchangeRateSourceType extends GeneralEntity {
    private String name;

}
