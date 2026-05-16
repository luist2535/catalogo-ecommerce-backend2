package com.ecommerce.catalog.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductoResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String nombre,
        @JsonProperty("description") String descripcion,
        @JsonProperty("price") Double precio,
        @JsonProperty("stock") Integer stock,
        @JsonProperty("category") String categoria,
        @JsonProperty("createdAt") LocalDateTime fechaCreacion
) {}
