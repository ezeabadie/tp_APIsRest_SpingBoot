🛒 API REST de Gestión de Productos
📋 Descripción del Proyecto

API REST completa desarrollada con Spring Boot para la gestión de productos de un sistema de inventario.
Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos, con validaciones robustas, manejo centralizado de errores y documentación automática mediante Swagger/OpenAPI.

Este proyecto demuestra la implementación de una arquitectura en capas profesional, aplicando principios SOLID y las mejores prácticas de desarrollo backend con Spring Boot.

⚙️ Tecnologías Utilizadas
Tecnología	Versión	Propósito
Java	17	Lenguaje de programación
Spring Boot	3.5.7	Framework principal
Spring Data JPA	-	Persistencia de datos
Hibernate	-	ORM (Object-Relational Mapping)
H2 Database	-	Base de datos en memoria
Maven	-	Gestión de dependencias
Lombok	-	Reducción de código boilerplate
Bean Validation	JSR-380	Validación de datos
Springdoc OpenAPI	2.8.4	Documentación automática de la API
Swagger UI	-	Interfaz interactiva para testing
🚀 Instrucciones para Clonar y Ejecutar
🧩 Prerrequisitos

Java 17 o superior instalado

Maven 3.6+ instalado

IDE recomendado: IntelliJ IDEA, Eclipse o VS Code

▶️ Pasos para ejecutar

Clonar el repositorio

git clone https://github.com/tu-usuario/productos-api.git
cd productos-api


Compilar el proyecto

mvn clean install


Ejecutar la aplicación

mvn spring-boot:run


O desde tu IDE, ejecutar la clase ProductosApiApplication.java.

Verificar que está funcionando
La aplicación estará disponible en:
👉 http://localhost:8080

📚 Endpoints de la API
Método	Ruta	Descripción	Status Codes
GET	/api/productos	Listar todos los productos	200 OK
GET	/api/productos/{id}	Obtener producto por ID	200 OK, 404 Not Found
GET	/api/productos/categoria/{categoria}	Filtrar productos por categoría	200 OK
POST	/api/productos	Crear nuevo producto	201 Created, 400 Bad Request
PUT	/api/productos/{id}	Actualizar producto completo	200 OK, 404 Not Found, 400 Bad Request
PATCH	/api/productos/{id}/stock	Actualizar solo el stock	200 OK, 404 Not Found, 400 Bad Request
DELETE	/api/productos/{id}	Eliminar producto	204 No Content, 404 Not Found
📦 Categorías Disponibles

ELECTRONICA

ROPA

ALIMENTOS

HOGAR

DEPORTES

📸 Capturas de Pantalla

Documentación completa en Swagger UI
<img width="1898" height="972" alt="image" src="https://github.com/user-attachments/assets/d2585e28-68d1-4af4-bb35-9e0c2fb5d00d" />

Prueba exitosa de POST (creando producto)
<img width="1600" height="716" alt="image" src="https://github.com/user-attachments/assets/10d09ba7-94ea-4ae4-9e07-d3682e94863f" />

Prueba de GET (listando productos y por categoría)
<img width="1600" height="620" alt="image" src="https://github.com/user-attachments/assets/ec965c86-7989-4314-ab2d-cde39e4f8f43" />
<img width="1600" height="739" alt="image" src="https://github.com/user-attachments/assets/64af2a92-5a00-4884-9e3d-94009ffe9aca" />
<img width="1600" height="832" alt="image" src="https://github.com/user-attachments/assets/bb06e2c6-102b-4461-9b07-727c1fb75b49" />

Error 404 al buscar producto inexistente
<img width="1600" height="788" alt="image" src="https://github.com/user-attachments/assets/94eafcbf-f982-4258-b885-efb7736745ad" />

Error 400 por validación fallida
<img width="1600" height="745" alt="image" src="https://github.com/user-attachments/assets/4a355077-d734-4653-976a-3beff21917de" />
<img width="1600" height="710" alt="image" src="https://github.com/user-attachments/assets/5f8ab2ad-fec8-41ee-9e8f-df1d27ad1c2c" />

Consola H2 mostrando los datos persistidos
<img width="1093" height="501" alt="image" src="https://github.com/user-attachments/assets/222198b8-ee30-4dab-a735-37924a8ed335" />

🏗️ Arquitectura del Proyecto
src/main/java/com/utn/productos/
├── controller/          # Controladores REST (Capa de presentación)
│   └── ProductoController.java
├── service/             # Lógica de negocio
│   └── ProductoService.java
├── repository/          # Acceso a datos (Spring Data JPA)
│   └── ProductoRepository.java
├── model/               # Entidades JPA
│   ├── Producto.java
│   └── Categoria.java
├── dto/                 # Data Transfer Objects
│   ├── ProductoDTO.java
│   ├── ProductoResponseDTO.java
│   └── ActualizarStockDTO.java
├── exception/           # Manejo de errores
│   ├── ProductoNotFoundException.java
│   ├── StockInsuficienteException.java
│   ├── ErrorResponse.java
│   └── GlobalExceptionHandler.java
└── ProductosApiApplication.java  # Clase principal

✨ Características Destacadas
🔒 Validaciones Robustas

Bean Validation (JSR-380) en todos los DTOs

Mensajes de error personalizados y descriptivos

Validación de tipos de datos, rangos y nulos

🛡️ Manejo Centralizado de Errores

@ControllerAdvice para capturar excepciones globalmente

Respuestas de error estandarizadas con timestamp, status, mensaje y ruta

Códigos HTTP correctos según el tipo de error (400, 404, 500)

📊 Persistencia con JPA/Hibernate

Generación automática de esquema DDL

Mapeo de enums como STRING para mayor legibilidad

Consultas derivadas con Spring Data JPA (findByCategoria)

📖 Documentación Automática

Swagger UI generado automáticamente

Anotaciones @Operation, @Schema, @ApiResponses

Documentación detallada de request/response

🎯 Arquitectura en Capas

Separación clara de responsabilidades

Desacoplamiento mediante interfaces y DTOs

Facilita testing y mantenibilidad

🧪 Testing Manual Realizado
Escenarios Probados

✅ POST - Crear producto con datos válidos (201 Created)
✅ POST - Crear producto con validaciones fallidas (400 Bad Request)
✅ GET - Listar todos los productos (200 OK)
✅ GET - Obtener producto existente (200 OK)
✅ GET - Obtener producto inexistente (404 Not Found)
✅ GET - Filtrar por categoría (200 OK)
✅ PUT - Actualizar producto completo (200 OK)
✅ PUT - Producto inexistente (404 Not Found)
✅ PATCH - Actualizar stock (200 OK)
✅ PATCH - Stock negativo rechazado (400 Bad Request)
✅ DELETE - Eliminar producto (204 No Content)
✅ DELETE - Producto inexistente (404 Not Found)
✅ H2 Console - Verificación de persistencia

💭 Conclusiones Personales
Lo Aprendido

Durante el desarrollo de este proyecto, consolidé conocimientos sobre:

Diseño de APIs REST:

Uso correcto de métodos HTTP según la operación

Aplicación semántica de códigos de estado

Estructuración RESTful de rutas

Arquitectura en Capas:

Separación Controller / Service / Repository

Uso de DTOs para desacoplar entidades

Ventajas en testing y mantenibilidad

Validaciones y Manejo de Errores:

Uso de @NotNull, @Size, @Min, @DecimalMin

Centralización de errores con @ControllerAdvice

Excepciones personalizadas (ProductoNotFoundException, etc.)

Persistencia con JPA/Hibernate:

Configuración de H2 y entidades JPA

Uso de @Enumerated(EnumType.STRING)

Consultas derivadas automáticas

Documentación con Swagger:

Generación automática con Springdoc

Uso de anotaciones descriptivas

Interfaz interactiva para testing

Desafíos Superados

Configuración de Lombok

Validaciones específicas para PATCH

Persistencia de Enums en JPA

Diseño de ErrorResponse estandarizado

Próximos Pasos

Implementar Testing automatizado (JUnit/Mockito)

Agregar Seguridad con JWT

Añadir paginación en listados

Migrar a PostgreSQL/MySQL

Dockerizar el proyecto

Configurar CI/CD con GitHub Actions

Reflexión Final

Este proyecto me permitió comprender que desarrollar una API REST profesional implica mucho más que crear endpoints:
✅ Diseñar una arquitectura escalable y mantenible
✅ Validar datos rigurosamente
✅ Manejar errores de forma clara
✅ Documentar correctamente la API
✅ Persistir datos de manera eficiente

👨‍💻 Autor
Nombre: Ezequiel Abadie
Legajo: 50737
Universidad: Universidad Tecnológica Nacional (UTN)
Materia: Desarrollo de Software
Año: 2025
