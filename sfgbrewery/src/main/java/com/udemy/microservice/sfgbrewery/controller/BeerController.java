package com.udemy.microservice.sfgbrewery.controller;

import com.udemy.microservice.sfgbrewery.model.BeerDto;
import com.udemy.microservice.sfgbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;
    public BeerController(BeerService beerService)
    {
        this.beerService=beerService;
    }

    @GetMapping("/health")
    public String hello()
    {
        return "Heath Ok";
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto)
    {
      BeerDto beerDto1=beerService.saveBeerDto(beerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("location","/api/v1/beer"+beerDto.getUuid().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeerDto(@PathVariable("beerId") UUID beerId)
    {
        beerService.updateBeerDto(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

