package org.good.job.currencyprojectreloaded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@EnableScheduling
public class CurrencyProjectReloadedApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyProjectReloadedApplication.class, args);
    }

}
