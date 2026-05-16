package com.ecommerce.catalog.service;

import com.ecommerce.catalog.dto.ProductoRequest;
import com.ecommerce.catalog.dto.ProductoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    Page<ProductoResponse> obtenerTodosLosProductos(String busqueda, Pageable pageable);
    ProductoResponse obtenerProductoPorId(Long id);
    ProductoResponse crearProducto(ProductoRequest request);
    ProductoResponse actualizarProducto(Long id, ProductoRequest request);
    void eliminarProducto(Long id);
}
