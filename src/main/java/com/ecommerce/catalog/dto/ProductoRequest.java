package com.ecommerce.catalog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductoRequest(
        
        @Schema(example = "Audífonos Inalámbricos Sony")
        @NotBlank(message = "El nombre del producto no puede estar vacío")
        @JsonProperty("name")
        String nombre,
        
        @Schema(example = "Cancelación de ruido activa, Bluetooth 5.0")
        @JsonProperty("description")
        String descripcion,
        
        @Schema(example = "850.0")
        @Positive(message = "El precio debe ser un valor positivo mayor a 0")
        @JsonProperty("price")
        Double precio,
        
        @Schema(example = "25")
        @Min(value = 0, message = "El stock no puede ser negativo")
        @JsonProperty("stock")
        Integer stock,
        
        @Schema(example = "Audio")
        @NotBlank(message = "La categoría del producto no puede estar vacía")
        @JsonProperty("category")
        String categoria
) {}
