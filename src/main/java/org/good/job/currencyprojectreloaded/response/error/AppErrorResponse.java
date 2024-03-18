package org.good.job.currencyprojectreloaded.response.error;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import org.springframework.http.ProblemDetail;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class AppErrorResponse {
    @JsonUnwrapped
    private ProblemDetail problemDetail;

}
