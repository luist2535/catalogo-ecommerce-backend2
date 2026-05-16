package com.ecommerce.catalog.service;

import com.ecommerce.catalog.dto.ProductoRequest;
import com.ecommerce.catalog.dto.ProductoResponse;
import com.ecommerce.catalog.entity.Producto;
import com.ecommerce.catalog.exception.ProductoNoEncontradoException;
import com.ecommerce.catalog.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Page<ProductoResponse> obtenerTodosLosProductos(String busqueda, Pageable pageable) {
        Page<Producto> productos;
        
        if (busqueda != null && !busqueda.trim().isEmpty()) {
            productos = productoRepository.findByNombreContainingIgnoreCaseOrCategoriaContainingIgnoreCase(busqueda, busqueda, pageable);
        } else {
            productos = productoRepository.findAll(pageable);
        }
        
        return productos.map(this::mapearAResponse);
    }

    @Override
    public ProductoResponse obtenerProductoPorId(Long id) {
        Producto producto = buscarProductoPorId(id);
        return mapearAResponse(producto);
    }

    @Override
    public ProductoResponse crearProducto(ProductoRequest request) {
        Producto nuevoProducto = new Producto(
                request.nombre(),
                request.descripcion(),
                request.precio(),
                request.stock(),
                request.categoria()
        );
        
        Producto productoGuardado = productoRepository.save(nuevoProducto);
        return mapearAResponse(productoGuardado);
    }

    @Override
    public ProductoResponse actualizarProducto(Long id, ProductoRequest request) {
        Producto productoExistente = buscarProductoPorId(id);
        
        productoExistente.setNombre(request.nombre());
        productoExistente.setDescripcion(request.descripcion());
        productoExistente.setPrecio(request.precio());
        productoExistente.setStock(request.stock());
        productoExistente.setCategoria(request.categoria());
        
        Producto productoActualizado = productoRepository.save(productoExistente);
        return mapearAResponse(productoActualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto productoExistente = buscarProductoPorId(id);
        productoRepository.delete(productoExistente);
    }
    
    private Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con el ID: " + id));
    }
    
    private ProductoResponse mapearAResponse(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria(),
                producto.getFechaCreacion()
        );
    }
}
