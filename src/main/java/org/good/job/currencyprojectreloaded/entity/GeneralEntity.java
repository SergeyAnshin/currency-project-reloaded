package org.good.job.currencyprojectreloaded.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString

@MappedSuperclass
public class GeneralEntity {
    @Id
    @GeneratedValue
    private long id;

}
