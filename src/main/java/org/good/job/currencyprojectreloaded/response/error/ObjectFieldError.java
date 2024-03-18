package org.good.job.currencyprojectreloaded.response.error;

import lombok.*;
import org.springframework.validation.FieldError;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ObjectFieldError {
    private String field;
    private String message;
    private Object rejectedValue;

    public ObjectFieldError(FieldError fieldError) {
        this.field         = fieldError.getField();
        this.message       = fieldError.getDefaultMessage();
        this.rejectedValue = fieldError.getRejectedValue();
    }

}
