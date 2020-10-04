package com.udemy.microservice.sfgbrewery.service;

import com.udemy.microservice.sfgbrewery.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeerDto(BeerDto beerDto);

    void updateBeerDto(UUID beerId);
}
