package com.ecommerce.catalog.config;

import com.ecommerce.catalog.entity.Producto;
import com.ecommerce.catalog.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                System.out.println("====== POBLANDO BASE DE DATOS ======");
                Producto p1 = new Producto();
                p1.setNombre("Laptop Gamer Lenovo Legion");
                p1.setDescripcion("Pantalla 15.6, RTX 4060, 16GB RAM");
                p1.setPrecio(4500.00);
                p1.setStock(15);
                p1.setCategoria("Laptops");
                p1.setFechaCreacion(LocalDateTime.now());

                Producto p2 = new Producto();
                p2.setNombre("Mouse Inalámbrico Logitech MX Master 3S");
                p2.setDescripcion("Alta precisión, ergonómico");
                p2.setPrecio(400.00);
                p2.setStock(50);
                p2.setCategoria("Periféricos");
                p2.setFechaCreacion(LocalDateTime.now());

                Producto p3 = new Producto();
                p3.setNombre("Teclado Mecánico Keychron K2");
                p3.setDescripcion("Switches Red, Bluetooth, RGB");
                p3.setPrecio(350.00);
                p3.setStock(30);
                p3.setCategoria("Periféricos");
                p3.setFechaCreacion(LocalDateTime.now());

                Producto p4 = new Producto();
                p4.setNombre("Monitor LG UltraGear 27\"");
                p4.setDescripcion("144Hz, 1ms, IPS");
                p4.setPrecio(1200.00);
                p4.setStock(20);
                p4.setCategoria("Monitores");
                p4.setFechaCreacion(LocalDateTime.now());

                Producto p5 = new Producto();
                p5.setNombre("Silla Ergonómica Herman Miller");
                p5.setDescripcion("Máxima comodidad para largas jornadas");
                p5.setPrecio(6500.00);
                p5.setStock(5);
                p5.setCategoria("Mobiliario");
                p5.setFechaCreacion(LocalDateTime.now());

                repository.saveAll(List.of(p1, p2, p3, p4, p5));
                System.out.println("====== 5 PRODUCTOS CREADOS ======");
            }
        };
    }
}
