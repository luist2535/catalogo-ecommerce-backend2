# Catálogo E-Commerce — Backend Spring Boot

API REST para la gestión de un catálogo de productos. Proyecto desarrollado con Spring Boot, Spring Data JPA, H2 y documentación OpenAPI.

## Tecnologías
- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- Spring Validation
- H2 Database
- SpringDoc OpenAPI (Swagger)
- Maven

## Descripción del proyecto
Este backend expone un conjunto de endpoints para gestionar productos en un catálogo de e-commerce. Incluye:
- Listado paginado de productos
- Búsqueda por nombre o categoría
- Consulta de producto por ID
- Creación, actualización y eliminación de productos
- Poblado inicial de datos de ejemplo
- Documentación automática con Swagger UI

## Modelo de producto
Cada producto incluye:
- `id`: Identificador del producto
- `name`: Nombre del producto
- `description`: Descripción del producto
- `price`: Precio del producto
- `stock`: Cantidad en inventario
- `category`: Categoría del producto
- `createdAt`: Fecha de creación en la base de datos

## Endpoints principales
Base: `http://localhost:8080/products`

1. `GET /products`
   - Lista productos paginados.
   - Parámetros opcionales:
     - `search`: texto para buscar por nombre o categoría
     - `page`: número de página (inicia en 0)
     - `size`: cantidad de elementos por página

2. `GET /products/{id}`
   - Obtiene un producto por su ID.

3. `POST /products`
   - Crea un nuevo producto.
   - Body JSON de ejemplo:
     ```json
     {
       "name": "Audífonos Inalámbricos Sony",
       "description": "Cancelación de ruido activa, Bluetooth 5.0",
       "price": 850.0,
       "stock": 25,
       "category": "Audio"
     }
     ```

4. `PUT /products/{id}`
   - Actualiza un producto existente.
   - Body JSON similar al de creación.

5. `DELETE /products/{id}`
   - Elimina un producto por su ID.

## Configuración y ejecución
### Requisitos
- Java 17
- Maven

### Ejecutar localmente
1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd ecommerce-catalog
   ```
2. Compila y ejecuta la aplicación:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
3. Abre en el navegador:
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - H2 Console: `http://localhost:8080/h2-console`

## Base de datos
El proyecto utiliza H2 en modo embebido con las siguientes credenciales por defecto:
- JDBC URL: `jdbc:h2:~/test`
- Usuario: `sa`
- Contraseña: (vacía)

Al arrancar, la aplicación inserta datos de ejemplo si no existen productos en la base de datos.

## Documentación de API
La documentación interactiva está disponible en:
- `http://localhost:8080/swagger-ui.html`

## Notas
- Se aplican validaciones en los campos de entrada para nombre, categoría, precio y stock.
- El campo `createdAt` se gestiona automáticamente con la fecha de creación.

---

Proyecto creado como ejemplo de backend para catálogo de productos con Spring Boot.
