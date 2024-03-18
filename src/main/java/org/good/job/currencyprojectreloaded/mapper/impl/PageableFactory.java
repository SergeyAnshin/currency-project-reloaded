package org.good.job.currencyprojectreloaded.mapper.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import static org.good.job.currencyprojectreloaded.service.constant.PaginationConstant.FIRST_PAGE_NUMBER;
import static org.good.job.currencyprojectreloaded.service.constant.PaginationConstant.MIN_PAGE_SIZE;

@Component
public class PageableFactory {

    public PageRequest createPageRequest() {
        return PageRequest.of(FIRST_PAGE_NUMBER, MIN_PAGE_SIZE);
    }

}
