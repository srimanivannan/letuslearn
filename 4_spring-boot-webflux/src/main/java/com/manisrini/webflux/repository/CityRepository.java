package com.manisrini.webflux.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.manisrini.webflux.model.City;

@Repository
public class CityRepository {

  private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();

  private static final AtomicLong idGenerator = new AtomicLong(0);

  public City save(City city) {
    Long id = idGenerator.incrementAndGet();
    city.setId(id);
    repository.put(id, city);
    return city;
  }

  public Collection<City> findAll() {
    City city = new City();
    city.setCityName("henrico");
    city.setDescription("description");
    city.setId(111L);
    city.setProvinceId(222L);
    repository.put(1L, city);
    return repository.values();
  }


  public City findCityById(Long id) {
    return repository.get(id);
  }

  public City updateCity(City city) {
    repository.put(city.getId(), city);
    return city;
  }

  public Long deleteCity(Long id) {
    repository.remove(id);
    return id;
  }
}
