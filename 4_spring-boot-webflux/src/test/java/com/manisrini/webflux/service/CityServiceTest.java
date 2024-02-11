package com.manisrini.webflux.service;


import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.manisrini.webflux.model.City;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityServiceTest {

  @Autowired
  private WebTestClient webClient;

  private static final Map<String, City> cityMap = new HashMap<>();

  @Test
  public void testSave() {
    City wl = new City();
    wl.setId(5L);
    wl.setProvinceId(2L);
    wl.setCityName("WL");
    wl.setDescription("WL IS GOOD");
    cityMap.put("WL", wl);

    City expectCity = webClient.post().uri("/city")
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(cityMap.get("WL")))
        .exchange()
        .expectStatus().isOk()
        .expectBody(City.class).returnResult().getResponseBody();

    Assertions.assertThat(expectCity).isNotNull();
    //Assertions.assertThat(expectCity.getId()).isEqualTo(cityMap.get("WL").getId());
    Assertions.assertThat(expectCity.getCityName()).isEqualTo(cityMap.get("WL").getCityName());
  }

}