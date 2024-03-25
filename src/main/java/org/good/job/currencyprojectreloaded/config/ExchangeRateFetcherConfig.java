package org.good.job.currencyprojectreloaded.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExchangeRateFetcherConfig {
    @Value("${fetcher.pool-size}")
    private int fetcherPoolSize;

    @Bean
    public RestClient fetcherRestClient() {
        return RestClient.create();
    }

    @Bean
    public ExecutorService fetcherExecutorService() {
        return Executors.newFixedThreadPool(fetcherPoolSize);
    }

}
