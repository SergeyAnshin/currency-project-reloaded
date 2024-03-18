package org.good.job.currencyprojectreloaded.repository;

import org.good.job.currencyprojectreloaded.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExchangeRateRepository
        extends JpaRepository<ExchangeRate, Long>, PagingAndSortingRepository<ExchangeRate, Long> {
}
