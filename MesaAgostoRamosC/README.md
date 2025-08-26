# 🎯 Sistema de Gestión de Eventos y Venta de Tickets

## 📋 Descripción del Proyecto

Este proyecto implementa un sistema web para gestionar eventos artísticos, clientes y la venta de tickets. El sistema permite crear, editar y eliminar eventos, gestionar clientes, y realizar compras de tickets con validaciones y reportes de recaudación.

## 🏗️ Arquitectura

- **Framework**: Spring Boot 3.2.3
- **Base de Datos**: MySQL 8
- **Frontend**: Thymeleaf + Bootstrap 5
- **Java**: JDK 17
- **Patrón**: MVC (Model-View-Controller)

## 🚀 Proceso de Desarrollo (Commits Progresivos)

### **Commit 1: "Estructura básica sin funcionalidad"**
- ✅ Modelos básicos (Evento, Cliente, Compra) sin validaciones
- ✅ Repositorios básicos extendiendo JpaRepository
- ✅ Servicios básicos con métodos CRUD simples
- ✅ Controladores básicos solo para listado
- ✅ Vistas HTML básicas sin estilos CSS
- ✅ Configuración mínima de Spring Boot

### **Commit 2: "Implementación de validaciones y relaciones"**
- ✅ Agregar validaciones Bean Validation (@NotNull, @NotBlank, etc.)
- ✅ Implementar relaciones JPA (@OneToMany, @ManyToOne)
- ✅ Crear enum TipoEvento
- ✅ Agregar campos adicionales (capacidadInicial, fechaCompra)

### **Commit 3: "Lógica de negocio y servicios completos"**
- ✅ Implementar lógica de disponibilidad de tickets
- ✅ Agregar validaciones de negocio
- ✅ Implementar cálculo de recaudación
- ✅ Agregar transacciones (@Transactional)

### **Commit 4: "Controladores y funcionalidad web completa"**
- ✅ Implementar CRUD completo en controladores
- ✅ Agregar manejo de formularios y validaciones
- ✅ Implementar redirecciones y mensajes flash
- ✅ Agregar manejo de excepciones

### **Commit 5: "Vistas y experiencia de usuario"**
- ✅ Agregar estilos CSS y Bootstrap
- ✅ Implementar navegación completa
- ✅ Agregar formularios funcionales
- ✅ Implementar reportes y estadísticas

### **Commit 6: "Configuración y despliegue"**
- ✅ Configurar base de datos MySQL
- ✅ Agregar carga inicial de datos
- ✅ Configurar logging y propiedades
- ✅ Documentación final

## 📁 Estructura del Proyecto

```
src/main/java/ar/edu/unju/fi/
├── controller/          # Controladores web
├── service/            # Lógica de negocio
├── repository/         # Acceso a datos
├── model/             # Entidades JPA
├── exception/         # Excepciones personalizadas
├── dto/               # Objetos de transferencia
├── converter/         # Convertidores
└── config/            # Configuraciones

src/main/resources/
├── templates/         # Vistas Thymeleaf
├── static/           # Recursos estáticos
└── application.properties
```

## 🗄️ Entidades del Sistema

### **Evento**
- nombre, descripción, fecha, lugar, precio, capacidad
- tipoEvento (RECITAL, OBRA_DE_TEATRO, STAND_UP)
- capacidadInicial, compras (relación OneToMany)

### **Cliente**
- nombre, apellido, email (único), dni (único)
- compras (relación OneToMany)

### **Compra**
- cliente, evento, cantidadTickets, total, fechaCompra
- Relaciones ManyToOne con Cliente y Evento

## 🔧 Funcionalidades Implementadas

- ✅ Gestión completa de eventos (CRUD)
- ✅ Gestión de clientes con validaciones
- ✅ Sistema de compra de tickets
- ✅ Cálculo automático de totales
- ✅ Validación de disponibilidad
- ✅ Reportes de recaudación
- ✅ Interfaz web responsive

## 🚀 Cómo Ejecutar

### **Requisitos Previos**
- Java 17 o superior
- MySQL 8
- Maven 3.6+

### **Pasos de Ejecución**
1. Clonar el repositorio
2. Crear base de datos MySQL: `mesapv`
3. Configurar credenciales en `application.properties`
4. Ejecutar: `mvn spring-boot:run`
5. Abrir: `http://localhost:8080`

## 📊 Rutas Principales

- **Inicio**: `/`
- **Eventos**: `/eventos`
- **Clientes**: `/clientes`
- **Compras**: `/compras`
- **Recaudación**: `/eventos/recaudacion`

## 🎨 Tecnologías Frontend

- **Thymeleaf**: Motor de plantillas
- **Bootstrap 5**: Framework CSS
- **jQuery**: Manipulación del DOM
- **Responsive Design**: Adaptable a móviles

## 🔒 Seguridad y Validaciones

- Validaciones Bean Validation
- Validaciones de negocio personalizadas
- Manejo de excepciones
- Transacciones para consistencia de datos

## 📈 Características Técnicas

- **Arquitectura en capas**: Separación clara de responsabilidades
- **JPA/Hibernate**: Mapeo objeto-relacional
- **Spring Data**: Repositorios automáticos
- **Transacciones**: Consistencia de datos
- **Logging**: Trazabilidad de operaciones

## 👨‍💻 Autor

- Camila Ramos

## 📚 Recursos de Aprendizaje

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [JPA/Hibernate Guide](https://hibernate.org/orm/documentation/)
- [Thymeleaf Tutorial](https://www.thymeleaf.org/documentation.html)
- [Bootstrap Documentation](https://getbootstrap.com/docs/)

---

*Este proyecto demuestra la implementación progresiva de un sistema web completo, desde la estructura básica hasta la funcionalidad completa, siguiendo las mejores prácticas de desarrollo con Spring Boot.*
