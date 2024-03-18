package org.good.job.currencyprojectreloaded.repository;

import org.good.job.currencyprojectreloaded.entity.ExchangeRateSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExchangeRateSourceRepository
        extends JpaRepository<ExchangeRateSource, Long>, PagingAndSortingRepository<ExchangeRateSource, Long> {
}
