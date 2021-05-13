package com.manisrini.webflux.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.manisrini.webflux.model.City;
import com.manisrini.webflux.service.CityService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

  @Autowired
  private CityService cityService;

  @GetMapping(value = "/{id}")
  public Mono<City> findCityById(@PathVariable("id") Long id) {
    return cityService.findCityById(id);
  }

  @GetMapping()
  public Flux<City> findAllCity() {
    return cityService.findAllCity();
  }

  @PostMapping()
  public Mono<City> saveCity(@RequestBody City city) {
    return cityService.save(city);
  }

  @PutMapping()
  public Mono<City> modifyCity(@RequestBody City city) {
    return cityService.modifyCity(city);
  }

  @DeleteMapping(value = "/{id}")
  public Mono<Long> deleteCity(@PathVariable("id") Long id) {
    return cityService.deleteCity(id);
  }
}
