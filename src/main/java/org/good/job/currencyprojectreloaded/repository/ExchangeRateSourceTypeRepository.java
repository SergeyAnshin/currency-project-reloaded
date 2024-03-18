package org.good.job.currencyprojectreloaded.repository;

import org.good.job.currencyprojectreloaded.entity.ExchangeRateSourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExchangeRateSourceTypeRepository
        extends JpaRepository<ExchangeRateSourceType, Long>, PagingAndSortingRepository<ExchangeRateSourceType, Long> {
}
