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

  public CityRepository() {
    City henrico = buildCity("henrico");
    repository.put(henrico.getId(), henrico);

    City plano = buildCity("plano");
    repository.put(plano.getId(), plano);

    City manhattan = buildCity("manhattan");
    repository.put(manhattan.getId(), manhattan);

    City fallschurch = buildCity("fallschurch");
    repository.put(fallschurch.getId(), fallschurch);
  }

  public City save(City city) {
    Long id = idGenerator.incrementAndGet();
    city.setId(id);
    repository.put(id, city);
    return city;
  }

  public Collection<City> findAll() {
    return repository.values();
  }

  private City buildCity(String cityName) {
    City city = new City();
    city.setCityName(cityName);
    city.setDescription("description");
    city.setId(idGenerator.incrementAndGet());
    city.setProvinceId(222L);
    return city;
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
