package com.manisrini.webflux.config;

import org.springdoc.webflux.core.converters.WebFluxSupportConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI api() {
    ModelConverters.getInstance().addConverter(new WebFluxSupportConverter());
    return new OpenAPI()
        .info(new Info().title("API")
            .description("Spring webflux reactive API")
            .version("v0.0.1")
            .license(new License().name("License of API").name("terms"))
            .termsOfService("terms"))
        .externalDocs(new ExternalDocumentation()
            .description("Docs")
            .url(""));
  }
}
