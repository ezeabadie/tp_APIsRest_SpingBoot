API REST de Gestión de Productos 🛒
📋 Descripción del Proyecto
API REST completa desarrollada con Spring Boot para la gestión de productos de un sistema de inventario. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos, con validaciones robustas, manejo centralizado de errores y documentación automática mediante Swagger/OpenAPI.
Este proyecto demuestra la implementación de una arquitectura en capas profesional, aplicando principios SOLID y las mejores prácticas de desarrollo backend con Spring Boot.
<hr></hr>
⚙️ Tecnologías Utilizadas
Tecnología
Versión
Propósito
Java
17
Lenguaje de programación
Spring Boot
3.5.7
Framework principal
Spring Data JPA
-
Persistencia de datos
Hibernate
-
ORM (Object-Relational Mapping)
H2 Database
-
Base de datos en memoria
Maven
-
Gestión de dependencias
Lombok
-
Reducción de código boilerplate
Bean Validation
-
Validación de datos (JSR-380)
Springdoc OpenAPI
2.8.4
Documentación automática de API
Swagger UI
-
Interfaz interactiva para testing
<hr></hr>
🚀 Instrucciones para Clonar y Ejecutar
Prerrequisitos
Java 17 o superior instalado
Maven 3.6+ instalado
IDE recomendado: IntelliJ IDEA, Eclipse o VS Code
Pasos para ejecutar
1. Clonar el repositorio
git clone https://github.com/tu-usuario/productos-api.git
cd productos-api

2. Compilar el proyecto
mvn clean install

3. Ejecutar la aplicación
mvn spring-boot:run

O desde tu IDE, ejecutar la clase ProductosApiApplication.java
4. Verificar que está funcionando
La aplicación estará disponible en: http://localhost:8080
<hr></hr>
📚 Endpoints de la API
Tabla de Endpoints
Método
Ruta
Descripción
Status Codes
GET
/api/productos
Listar todos los productos
200 OK
GET
/api/productos/{id}
Obtener producto por ID
200 OK, 404 Not Found
GET
/api/productos/categoria/{categoria}
Filtrar por categoría
200 OK
POST
/api/productos
Crear nuevo producto
201 Created, 400 Bad Request
PUT
/api/productos/{id}
Actualizar producto completo
200 OK, 404 Not Found, 400 Bad Request
PATCH
/api/productos/{id}/stock
Actualizar solo el stock
200 OK, 404 Not Found, 400 Bad Request
DELETE
/api/productos/{id}
Eliminar producto
204 No Content, 404 Not Found
Categorías Disponibles
ELECTRONICA
ROPA
ALIMENTOS
HOGAR
DEPORTES
<hr></hr>
📸 Capturas de Pantalla
1. Documentación Completa en Swagger UI
