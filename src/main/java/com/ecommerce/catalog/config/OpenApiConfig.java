package com.ecommerce.catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API REST - Taller Práctico")
                        .version("1.0.0")
                        .description("Documentación interactiva de la API para la gestión de catálogo de productos.")
                        .contact(new Contact()
                                .name("Estudiante Backend")
                                .email("estudiante@universidad.edu")));
    }
}
