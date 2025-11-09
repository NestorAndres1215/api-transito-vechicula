# Sistema de Gestión de Papeletas de Tránsito 🚓📄

Este proyecto es un sistema para la **gestión de papeletas de tránsito**, que permite registrar propietarios, vehículos, policías, infracciones y papeletas emitidas.  
Está desarrollado con **Spring Boot**, utilizando **JPA/Hibernate** para la persistencia de datos y **Swagger** para la documentación de la API.

---

## 🏗 Tecnologías Usadas

| Tecnología | Uso |
|-----------|-----|
| Java 17+ | Lenguaje principal |
| Spring Boot 3 | Framework para el backend |
| Spring Data JPA | Acceso a base de datos |
| Hibernate | ORM |
| MySQL / PostgreSQL (compatible) | Base de datos |
| Maven | Gestión de dependencias |
| Swagger UI (springdoc-openapi) | Documentación de la API |
| Lombok | Simplificación de entidades |

---

## 📌 Características del Sistema

- Registro de **Propietarios** de vehículos.
- Control de **Policías** que emiten papeletas.
- Gestión de **Infracciones** de tránsito.
- Registro y consulta de **Vehículos**.
- Generación y seguimiento de **Papeletas**.
- Sistema de eliminación lógica (`eliminado = 'Si' | 'No'`).
- Endpoints documentados en Swagger.

---
