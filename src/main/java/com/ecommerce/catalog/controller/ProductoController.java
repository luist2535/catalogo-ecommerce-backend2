package com.ecommerce.catalog.controller;

import com.ecommerce.catalog.dto.ProductoRequest;
import com.ecommerce.catalog.dto.ProductoResponse;
import com.ecommerce.catalog.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "Producto", description = "Endpoints para la gestión de productos del catálogo")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Listar productos", description = "Retorna una lista paginada de productos. Permite búsqueda por nombre o categoría de manera opcional.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta exitosa")
    })
    @GetMapping
    public ResponseEntity<Page<ProductoResponse>> obtenerTodosLosProductos(
            @Parameter(description = "Texto para buscar en nombre o categoría (Opcional)") 
            @RequestParam(required = false) String search,
            @Parameter(description = "Configuración de paginación (ej: page=0&size=5)") 
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        Page<ProductoResponse> productos = productoService.obtenerTodosLosProductos(search, pageable);
        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Obtener producto por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtenerProductoPorId(@PathVariable Long id) {
        ProductoResponse producto = productoService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Crear nuevo producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Creación exitosa"),
        @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@Valid @RequestBody ProductoRequest request) {
        ProductoResponse nuevoProducto = productoService.crearProducto(request);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Actualización exitosa"),
        @ApiResponse(responseCode = "400", description = "Error de validación"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizarProducto(
            @PathVariable Long id, 
            @Valid @RequestBody ProductoRequest request) {
        ProductoResponse productoActualizado = productoService.actualizarProducto(id, request);
        return ResponseEntity.ok(productoActualizado);
    }

    @Operation(summary = "Eliminar producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Eliminación exitosa"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
