package org.good.job.currencyprojectreloaded.dto;

import jakarta.validation.Valid;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RequestParametersData {
    @Valid
    private PageData pageData;

}
