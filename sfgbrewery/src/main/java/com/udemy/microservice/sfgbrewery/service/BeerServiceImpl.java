package com.udemy.microservice.sfgbrewery.service;

import com.udemy.microservice.sfgbrewery.model.BeerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().uuid(UUID.randomUUID())
                .beerName("Buddweiser")
                .beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto saveBeerDto( BeerDto beerDto) {
        return BeerDto.builder().beerName("BeerCreate").beerStyle("Pale ALe").build();
    }

    @Override
    public void updateBeerDto(UUID beerId) {
        //to update
    }
}
