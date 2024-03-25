package org.good.job.currencyprojectreloaded.fetcher.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.entity.EndpointData;
import org.good.job.currencyprojectreloaded.fetcher.ExchangeRateFetcher;
import org.good.job.currencyprojectreloaded.fetcher.ExchangeRatesFetchTask;
import org.good.job.currencyprojectreloaded.fetcher.FetchTaskDependenciesData;
import org.good.job.currencyprojectreloaded.service.EndpointDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor

@Component
public class ExchangeRateFetcherImpl implements ExchangeRateFetcher {
    private final Logger logger = LoggerFactory.getLogger(ExchangeRateFetcherImpl.class);
    private final EndpointDataService endpointDataService;
    private final ExecutorService fetcherExecutorService;
    private final FetchTaskDependenciesData fetchTaskDependenciesData;
    @Value("${cpr.log.message.fetcher.fetch-task-problem}")
    public String fetchTaskProblemLogMessage;
    @Value("${cpr.log.message.fetcher.missing-fetch-urls}")
    public String missingFetchUrlsLogMessage;

    @Scheduled(cron = "${fetcher.cron}")
    @Override
    public void fetch() {
        List<EndpointData> endpointDataList = endpointDataService.getEndpointDataListForFetching();
        if (endpointDataList.isEmpty()) {
            logger.error(missingFetchUrlsLogMessage, endpointDataService.getClass());
        } else {
            List<ExchangeRatesFetchTask> fetchTasks = endpointDataList.stream()
                    .map(endpointData -> new ExchangeRatesFetchTask(fetchTaskDependenciesData, endpointData))
                    .toList();
            execute(fetchTasks);
        }

    }

    private void execute(List<ExchangeRatesFetchTask> fetchTasks) {
        for (ExchangeRatesFetchTask fetchTask : fetchTasks) {
            try {
                fetcherExecutorService.execute(fetchTask);
            } catch (RuntimeException e) {
                logger.error(fetchTaskProblemLogMessage, fetchTask);
            }
        }
    }

}
