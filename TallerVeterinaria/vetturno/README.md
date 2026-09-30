# VetTurno

API REST para la gestión de citas de **Veterinaria Huellitas**.

VetTurno permite registrar propietarios, mascotas, veterinarios y citas, controlando la disponibilidad de los veterinarios y protegiendo los endpoints mediante autenticación JWT y roles.

---

## Alcance

El sistema permite:

- Registrar usuarios.
- Iniciar sesión mediante JWT.
- Registrar y consultar propietarios.
- Registrar y consultar mascotas.
- Registrar y consultar veterinarios.
- Crear citas veterinarias.
- Consultar todas las citas.
- Filtrar citas por veterinario.
- Evitar citas duplicadas para un veterinario en la misma fecha y hora.
- Validar los datos recibidos.
- Manejar errores de forma centralizada.
- Restringir operaciones según los roles USER y ADMIN.
- Probar la API mediante Swagger/OpenAPI.

---

## Tecnologías

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- JWT
- Bean Validation
- Swagger / OpenAPI
- Git
- GitHub

> El documento original del taller utiliza Java 17 como referencia. Este proyecto fue desarrollado y probado localmente con Java 25.

---

## Arquitectura

El proyecto utiliza una arquitectura organizada por responsabilidades:

```text
com.vetturno.vetturno
│
├── config
├── controller
├── dto
├── exception
├── model
├── repository
├── security
├── service
└── VetturnoApplication.java
```

### Responsabilidad de las capas

- **model:** entidades JPA persistidas en MySQL.
- **repository:** acceso a datos mediante Spring Data JPA.
- **service:** lógica de negocio.
- **controller:** endpoints REST.
- **dto:** objetos utilizados para entrada y salida de datos.
- **security:** autenticación JWT y autorización por roles.
- **exception:** manejo global y formato de errores.
- **config:** configuración adicional de la aplicación y OpenAPI.

---

## Modelo principal

VetTurno utiliza las siguientes entidades:

### Propietario

Representa al responsable de una o varias mascotas.

### Mascota

Pertenece a un propietario.

### Veterinario

Profesional encargado de atender las citas.

### Cita

Relaciona una mascota con un veterinario en una fecha y hora determinadas.

### Usuario

Representa al usuario que puede autenticarse en la API.

Los usuarios tienen uno de los siguientes roles:

- `USER`
- `ADMIN`

---

## Requisitos

Para ejecutar el proyecto se necesita:

- Java 25
- Maven
- MySQL 8
- Git, si se desea clonar el repositorio

---

## Base de datos

Crear una base de datos MySQL llamada:

```sql
CREATE DATABASE vetturno;
```

La aplicación utiliza JPA/Hibernate para crear o actualizar las tablas necesarias.

---

## Configuración

Configurar la conexión a MySQL en:

```text
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.application.name=vetturno

spring.datasource.url=jdbc:mysql://localhost:3306/vetturno
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Las credenciales reales de la base de datos y los secretos utilizados para JWT no deben publicarse en el repositorio.

---

## Ejecución

Desde Windows:

```bash
.\mvnw.cmd spring-boot:run
```

También puede ejecutarse directamente desde IntelliJ utilizando:

```text
VetturnoApplication
```

La aplicación queda disponible en:

```text
http://localhost:8080
```

---

## Swagger / OpenAPI

Con la aplicación ejecutándose, Swagger está disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger permite:

- visualizar los endpoints;
- realizar peticiones;
- iniciar sesión;
- utilizar el JWT mediante el botón **Authorize**;
- probar los endpoints protegidos.

---

## Autenticación

### Registro

```http
POST /api/auth/register
```

Ejemplo:

```json
{
  "nombre": "Usuario Prueba",
  "email": "usuario@vetturno.com",
  "password": "123456"
}
```

Todo usuario registrado mediante este endpoint recibe automáticamente el rol:

```text
USER
```

El cliente no puede asignarse el rol ADMIN mediante el registro.

---

### Login

```http
POST /api/auth/login
```

Ejemplo:

```json
{
  "email": "usuario@vetturno.com",
  "password": "123456"
}
```

La respuesta contiene un token JWT.

Para acceder a los endpoints protegidos se utiliza:

```text
Authorization: Bearer TOKEN
```

En Swagger se puede utilizar el botón:

```text
Authorize
```

---

## Roles y permisos

### USER

Puede:

- consultar información;
- registrar propietarios;
- registrar mascotas;
- crear citas.

No puede registrar veterinarios.

### ADMIN

Puede realizar las operaciones permitidas a USER y además:

- registrar veterinarios.

El primer usuario ADMIN se habilita de manera controlada directamente en la base de datos.

---

## Endpoints principales

### Autenticación

| Método | Endpoint | Descripción | Acceso |
|---|---|---|---|
| POST | `/api/auth/register` | Registrar usuario | Público |
| POST | `/api/auth/login` | Iniciar sesión | Público |

### Propietarios

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/propietarios` | Registrar propietario |
| GET | `/api/propietarios` | Listar propietarios |

### Mascotas

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/mascotas` | Registrar mascota |
| GET | `/api/mascotas` | Listar mascotas |

### Veterinarios

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/veterinarios` | Registrar veterinario |
| GET | `/api/veterinarios` | Listar veterinarios |

El registro de veterinarios requiere rol:

```text
ADMIN
```

### Citas

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/citas` | Crear cita |
| GET | `/api/citas` | Listar todas las citas |
| GET | `/api/citas/veterinario/{id}` | Consultar citas de un veterinario |

---

## Reglas de negocio de las citas

Antes de guardar una cita, VetTurno comprueba:

1. Que la mascota exista.
2. Que el veterinario exista.
3. Que la fecha y hora sean futuras.
4. Que el veterinario no tenga otra cita exactamente en la misma fecha y hora.

Si el veterinario ya está ocupado se devuelve:

```text
400 Bad Request
```

Ejemplo:

```json
{
  "errores": {},
  "mensaje": "El veterinario ya tiene una cita en ese horario",
  "status": 400,
  "timestamp": "..."
}
```

---

## Validaciones

Los DTO de entrada utilizan Bean Validation.

Entre las reglas utilizadas se encuentran:

- `@NotBlank`
- `@NotNull`
- `@Email`
- `@Size`
- `@Future`

Los controllers activan estas reglas mediante la anotación `@Valid`.



## Manejo de errores

VetTurno utiliza un manejador global de excepciones.

El formato utilizado es:

```json
{
  "status": 400,
  "mensaje": "Error de validación",
  "errores": {
    "campo": "Descripción del error"
  },
  "timestamp": "..."
}
```

Estados HTTP principales:

| Estado | Uso |
|---|---|
| 200 | Consulta o autenticación correcta |
| 201 | Recurso creado correctamente |
| 400 | Datos inválidos o regla de negocio incumplida |
| 403 | Usuario autenticado sin permiso |
| 500 | Error interno inesperado |

Los errores internos no exponen trazas ni detalles sensibles al cliente.

---

## Flujo recomendado de prueba

1. Iniciar MySQL.
2. Ejecutar VetTurno.
3. Abrir Swagger.
4. Registrar un usuario.
5. Iniciar sesión.
6. Copiar el JWT.
7. Pulsar **Authorize**.
8. Registrar un propietario.
9. Registrar una mascota.
10. Registrar un veterinario utilizando ADMIN.
11. Crear una cita.
12. Consultar la agenda.
13. Probar un horario duplicado.
14. Probar validaciones incorrectas.

---

## Pruebas realizadas

Durante el desarrollo se comprobaron manualmente los siguientes escenarios.

| Prueba | Resultado |
|---|---|
| Aplicación inicia con MySQL | Correcto |
| Login con credenciales válidas | 200 |
| Endpoint protegido con JWT | 200 |
| Creación válida de propietario | 201 |
| Propietario con varios campos inválidos | 400 |
| Creación válida de mascota | 201 |
| USER intenta crear veterinario | 403 |
| ADMIN crea veterinario | 201 |
| Creación válida de cita futura | 201 |
| Cita con fecha pasada | 400 |
| Cita con mascota inexistente | 400 |
| Segundo intento con mismo veterinario y horario | 400 |
| Filtro de citas por veterinario | 200 |
| Reinicio de la aplicación y consulta de datos persistidos | Correcto |
| Swagger utilizando Authorize y JWT | Correcto |

---

## Ejemplo de cita creada

```json
{
  "id": 1,
  "fechaHora": "2026-10-05T10:00:00",
  "motivo": "Consulta general",
  "mascota": "Max",
  "propietario": "Carlos Gómez",
  "veterinario": "Laura Martínez"
}
```

---

## Persistencia

Los datos permanecen almacenados en MySQL después de reiniciar la aplicación.

Se verificó reiniciando VetTurno y consultando nuevamente las citas mediante Swagger.

---

## Seguridad

La aplicación utiliza:

- Spring Security;
- BCrypt para almacenar contraseñas;
- JWT para autenticación;
- sesiones stateless;
- roles USER y ADMIN;
- protección de endpoints de negocio.

Las contraseñas no se almacenan en texto plano.

---

## Errores frecuentes

### 401 o 403 al utilizar un endpoint

Comprobar que:

- se realizó login;
- el JWT continúa vigente;
- el token fue agregado mediante **Authorize**;
- el usuario posee el rol necesario.

### Error de conexión con MySQL

Verificar:

- que MySQL esté iniciado;
- que exista la base `vetturno`;
- usuario y contraseña;
- puerto utilizado por MySQL.

### No se puede crear un veterinario

El usuario debe tener rol:

```text
ADMIN
```

### No se puede crear una cita

Comprobar:

- que la mascota exista;
- que el veterinario exista;
- que la fecha sea futura;
- que el veterinario no tenga otra cita en ese horario.

---

## Construcción con Maven

Para generar el paquete de la aplicación:

```bash
.\mvnw.cmd clean package -DskipTests
```

El archivo generado queda dentro de:

```text
target/
```

---

## Control de versiones

El proyecto utiliza Git y se encuentra publicado en GitHub.

Antes de publicar cambios se recomienda comprobar:

```bash
git status
```

Posteriormente:

```bash
git add .
git commit -m "feat: completar VetTurno"
git push
```

No deben publicarse:

- contraseñas;
- tokens JWT;
- secretos;
- archivos generados dentro de `target`;
- archivos locales del IDE.

---

## Uso de inteligencia artificial

Durante el desarrollo se utilizó inteligencia artificial como herramienta de apoyo para comprender conceptos, revisar implementaciones y diagnosticar errores.

Las sugerencias incorporadas fueron contrastadas con los requisitos del taller y verificadas mediante ejecución real de la aplicación, Swagger, MySQL y pruebas manuales.

---

## Estado del proyecto

VetTurno cuenta con:

- persistencia MySQL;
- arquitectura por capas;
- DTO de entrada y salida;
- API REST;
- reglas de negocio para citas;
- autenticación JWT;
- roles USER y ADMIN;
- validaciones;
- manejo global de errores;
- Swagger/OpenAPI;
- pruebas manuales;
- control de versiones con Git y GitHub.