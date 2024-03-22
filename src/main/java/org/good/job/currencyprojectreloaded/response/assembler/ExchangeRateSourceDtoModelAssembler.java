package org.good.job.currencyprojectreloaded.response.assembler;

import org.good.job.currencyprojectreloaded.controller.ExchangeRateSourceController;
import org.good.job.currencyprojectreloaded.dto.ExchangeRateSourceDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.good.job.currencyprojectreloaded.response.assembler.ModelAssemblerConstant.ALL_EXCHANGE_RATE_SOURCES_LINK_RELATION;
import static org.good.job.currencyprojectreloaded.response.assembler.ModelAssemblerConstant.REQUEST_PARAMETERS_DATA;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ExchangeRateSourceDtoModelAssembler implements RepresentationModelAssembler<ExchangeRateSourceDto,
        EntityModel<ExchangeRateSourceDto>> {

    @Override
    public EntityModel<ExchangeRateSourceDto> toModel(ExchangeRateSourceDto exchangeRateSource) {
        Link linkToAllExchangeRateSources = linkTo(
                methodOn(ExchangeRateSourceController.class).getAllExchangeRateSources(
                        REQUEST_PARAMETERS_DATA)).withRel(ALL_EXCHANGE_RATE_SOURCES_LINK_RELATION);
        List<Link> links = List.of(linkToAllExchangeRateSources);
        return EntityModel.of(exchangeRateSource, links);
    }

}
