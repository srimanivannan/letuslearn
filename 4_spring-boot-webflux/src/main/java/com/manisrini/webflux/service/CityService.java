package com.manisrini.webflux.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manisrini.webflux.model.City;
import com.manisrini.webflux.repository.CityRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityService {

  private final CityRepository cityRepository;

  @Autowired
  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Mono<City> save(City city) {
    return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
  }

  public Mono<City> findCityById(Long id) {
    return Mono.justOrEmpty(cityRepository.findCityById(id)).log();
  }

  public Flux<City> findAllCity() {
    Flux<City> cityFlux = Flux.fromIterable(cityRepository.findAll());
    return cityFlux;
  }

  public Mono<City> modifyCity(City city) {
    return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.updateCity(city)));
  }

  public Mono<Long> deleteCity(Long id) {
    return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.deleteCity(id)));
  }
}