package com.ecommerce.catalog.repository;

import com.ecommerce.catalog.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Método para buscar por nombre o categoría (útil para puntos extra)
    Page<Producto> findByNombreContainingIgnoreCaseOrCategoriaContainingIgnoreCase(String nombre, String categoria, Pageable pageable);
}
