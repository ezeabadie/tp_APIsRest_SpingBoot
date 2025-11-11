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
<img width="1600" height="739" alt="image" src="https://github.com/user-attachments/assets/64af2a92-5a00-4884-9c3d-94009ffe9aca" />
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
Diferentes códigos HTTP según el tipo de error (400, 404, 500)
📊 Persistencia con JPA/Hibernate
Generación automática de esquema DDL
Mapeo de enums como STRING para legibilidad
Consultas derivadas con Spring Data JPA (findByCategoria)
📖 Documentación Automática
Swagger UI generado automáticamente
Anotaciones @Operation, @Schema, @ApiResponses para descripción detallada
Schemas JSON Schema para request/response
🎯 Arquitectura en Capas
Separación clara de responsabilidades
Desacoplamiento entre capas mediante interfaces y DTOs
Facilita testing unitario y mantenibilidad
<hr></hr>
🧪 Testing Manual Realizado
Escenarios Probados
✅ POST - Crear producto con datos válidos (201 Created)
✅ POST - Crear producto con validaciones fallidas (400 Bad Request)
✅ GET - Listar todos los productos (200 OK)
✅ GET - Obtener producto existente por ID (200 OK)
✅ GET - Obtener producto inexistente (404 Not Found)
✅ GET - Filtrar productos por categoría (200 OK)
✅ PUT - Actualizar producto completo (200 OK)
✅ PUT - Actualizar producto inexistente (404 Not Found)
✅ PATCH - Actualizar solo el stock (200 OK)
✅ PATCH - Stock negativo rechazado (400 Bad Request)
✅ DELETE - Eliminar producto existente (204 No Content)
✅ DELETE - Eliminar producto inexistente (404 Not Found)
✅ H2 Console - Verificación de persistencia de datos
<hr></hr>
💭 Conclusiones Personales
Lo Aprendido
Durante el desarrollo de este proyecto, pude consolidar conocimientos clave sobre:
1. Diseño de APIs REST:
Comprendí la importancia de seleccionar correctamente los métodos HTTP según la operación (POST para crear, PUT para actualización completa, PATCH para parcial, DELETE para eliminar)
Aprendí a utilizar los códigos de estado HTTP de forma semántica (201 Created, 204 No Content, 400 Bad Request, 404 Not Found)
Entendí el concepto de recursos y cómo estructurar rutas RESTful (/api/productos, /api/productos/{id})
2. Arquitectura en Capas:
Implementé el patrón de separación de responsabilidades: Controller (presentación), Service (lógica de negocio), Repository (persistencia)
Aprendí a desacoplar capas mediante DTOs, evitando exponer entidades directamente en la API
Comprendí los beneficios de esta arquitectura para testing y mantenibilidad del código
3. Validaciones y Manejo de Errores:
Utilicé Bean Validation con anotaciones como @NotNull, @Size, @Min, @DecimalMin
Implementé un GlobalExceptionHandler con @ControllerAdvice para centralizar el manejo de errores
Aprendí a crear excepciones personalizadas (ProductoNotFoundException, StockInsuficienteException)
Diseñé respuestas de error estandarizadas con información útil para debugging
4. Persistencia con JPA/Hibernate:
Configuré correctamente Spring Data JPA con H2 en memoria
Utilicé anotaciones JPA (@Entity, @Id, @GeneratedValue, @Enumerated)
Aprendí a crear consultas derivadas (findByCategoria) sin escribir SQL
Comprendí el ciclo de vida de las entidades y cómo Hibernate gestiona las transacciones
5. Documentación con Swagger:
Integré Springdoc OpenAPI para generar documentación automática
Utilicé anotaciones como @Operation, @ApiResponses, @Schema para enriquecer la documentación
Aprendí el valor de tener una interfaz interactiva para probar endpoints sin necesidad de Postman
Desafíos Superados
Configuración de Lombok: Inicialmente tuve problemas con la generación de getters/setters, pero configuré correctamente el annotationProcessorPaths en Maven
Validaciones en PATCH: Entendí la diferencia entre actualización completa (PUT) y parcial (PATCH), y cómo validar solo los campos necesarios
Enums en JPA: Aprendí a persistir enums como STRING (@Enumerated(EnumType.STRING)) para mejorar la legibilidad en la base de datos
Manejo de errores personalizado: Diseñé una estructura de ErrorResponse que proporciona información útil sin exponer detalles sensibles
Próximos Pasos
Basándome en esta experiencia, me gustaría explorar:
Testing Automatizado: Implementar tests unitarios con JUnit/Mockito y tests de integración con MockMvc
Seguridad: Agregar Spring Security con autenticación JWT
Paginación: Implementar Pageable en los endpoints de listado
Base de Datos Persistente: Migrar de H2 en memoria a PostgreSQL/MySQL
Dockerización: Crear un Dockerfile y docker-compose.yml para facilitar el despliegue
CI/CD: Configurar pipelines con GitHub Actions o GitLab CI
Reflexión Final
Este proyecto me permitió entender que desarrollar una API REST profesional va más allá de simplemente crear endpoints. Implica:
Diseñar una arquitectura escalable y mantenible
Validar datos de entrada para garantizar integridad
Manejar errores de forma clara y consistente
Documentar la API para facilitar su consumo
Persistir datos de forma eficiente con JPA/Hibernate
Considero que este proyecto representa un punto de partida sólido para desarrollar aplicaciones backend más complejas con Spring Boot.
<hr></hr>
👨‍💻 Autor
Nombre: [Tu Nombre Completo]
Legajo: [Tu Número de Legajo]
Universidad: Universidad Tecnológica Nacional (UTN)
Carrera: [Tu Carrera]
Materia: [Nombre de la Materia]
Año: 2025
<hr></hr>
