package org.good.job.currencyprojectreloaded.response.assembler;

import lombok.RequiredArgsConstructor;
import org.good.job.currencyprojectreloaded.controller.ExchangeRateSourceController;
import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceDto;
import org.good.job.currencyprojectreloaded.dto.ExchangeRatesSourcesDto;
import org.good.job.currencyprojectreloaded.response.ExchangeRatesSourcesResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.good.job.currencyprojectreloaded.response.assembler.ModelAssemblerConstant.REQUEST_PARAMETERS_DATA;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor

@Component
public class ExchangeRatesSourcesResponseModelAssembler implements RepresentationModelAssembler<ExchangeRatesSourcesDto,
        EntityModel<ExchangeRatesSourcesResponse>> {
    private final ExchangeRateSourceDtoModelAssembler assembler;

    @Override
    public EntityModel<ExchangeRatesSourcesResponse> toModel(ExchangeRatesSourcesDto exchangeRatesSourcesDto) {
        CollectionModel<EntityModel<ExchangeRateSourceDto>> collectionModel = assembler.toCollectionModel(
                exchangeRatesSourcesDto.getExchangeRateSources());
        ExchangeRatesSourcesResponse exchangeRatesSourcesResponse = ExchangeRatesSourcesResponse.builder()
                .exchangeRateSources(collectionModel)
                .pageData(exchangeRatesSourcesDto.getPageData())
                .build();
        Link linkToAllExchangeRateSources = linkTo(
                methodOn(ExchangeRateSourceController.class).getAllExchangeRateSources(
                        REQUEST_PARAMETERS_DATA)).withSelfRel();
        List<Link> links = List.of(linkToAllExchangeRateSources);
        return EntityModel.of(exchangeRatesSourcesResponse, links);
    }

}
