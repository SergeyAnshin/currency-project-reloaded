package org.good.job.currencyprojectreloaded.service.impl;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.entity.EndpointData;
import org.good.job.currencyprojectreloaded.repository.EndpointDataRepository;
import org.good.job.currencyprojectreloaded.service.EndpointDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class EndpointDataServiceImpl implements EndpointDataService {
    private final EndpointDataRepository endpointDataRepository;

    @Override
    public List<EndpointData> getEndpointDataListForFetching() {
        return endpointDataRepository.findAll();
    }

    public List<String> getDatePatterns() {
        return List.of("dd.MM.yyyy");
    }

}
