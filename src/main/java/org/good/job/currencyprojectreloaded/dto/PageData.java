package org.good.job.currencyprojectreloaded.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.good.job.currencyprojectreloaded.validator.PageCheck;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Sort;

import static org.good.job.currencyprojectreloaded.service.constant.PaginationConstant.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PageData {
    @Min(value = FIRST_PAGE_NUMBER, groups = PageCheck.class)
    private int pageNumber;
    @Range(min = MIN_PAGE_SIZE, max = MAX_PAGE_SIZE, groups = PageCheck.class)
    private int pageSize;
    private long totalElements;
    private Sort sort;

}
