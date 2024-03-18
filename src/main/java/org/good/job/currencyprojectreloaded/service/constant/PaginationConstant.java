package org.good.job.currencyprojectreloaded.service.constant;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public final class PaginationConstant {
    public static final int FIRST_PAGE_NUMBER = 0;
    public static final int MIN_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;
    public static final Pageable DEFAULT_PAGEABLE_OBJECT = PageRequest.of(FIRST_PAGE_NUMBER, MIN_PAGE_SIZE);

}
