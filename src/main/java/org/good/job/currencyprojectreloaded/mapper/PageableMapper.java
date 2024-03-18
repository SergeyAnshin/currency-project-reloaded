package org.good.job.currencyprojectreloaded.mapper;

import org.good.job.currencyprojectreloaded.dto.PageData;
import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static java.util.Objects.nonNull;
import static org.good.job.currencyprojectreloaded.service.constant.PaginationConstant.DEFAULT_PAGEABLE_OBJECT;

@Mapper
public interface PageableMapper {

    default Pageable toPageable(PageData pageData) {
        if (nonNull(pageData)) {
            return PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        } else {
            return DEFAULT_PAGEABLE_OBJECT;
        }
    }

    @Mapping(target = "pageNumber", source = "pageable.pageNumber")
    @Mapping(target = "pageSize", source = "pageable.pageSize")
    @Mapping(target = "sort", source = "sort")
    PageData toPageData(Page<ExchangeRateSource> exchangeRateSourcePage);

}
