# Proyecto de Gestión de Matrícula Escolar

Este proyecto es una aplicación de gestión de matrículas escolares desarrollada con **Spring Boot** y **Thymeleaf**. La aplicación permite la gestión de órdenes de pago, constancias de matrícula, comprobantes de pago, y reservas de matrícula, integrando relaciones entre entidades como alumnos, responsables de caja, y tesoreros.

## Tecnologías y Herramientas Utilizadas

- **Java 17**
- **Spring Boot 3.0**
- **Thymeleaf**
- **JPA (Hibernate)** para el manejo de base de datos
- **MySQL Driver** para la conexión con la base de datos MySQL
- **JasperReports** para la generación de reportes en PDF
- **IntelliJ IDEA** para el desarrollo

## Requisitos Previos

Asegúrate de tener instalado en tu sistema:

- **JDK 17**
- **IntelliJ IDEA** (recomendado para la ejecución y edición del proyecto)

## Configuración Inicial del Proyecto

### Paso 1: Clonar el Repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/MichaelVairoCibertec/cibertec_matricula.git
cd cibertec_matricula
```

### Paso 2: Configuración del archivo `application.properties`

Asegúrate de que el archivo [application.properties](http://_vscodecontentref_/#%7B%22uri%22%3A%7B%22%24mid%22%3A1%2C%22fsPath%22%3A%22d%3A%5C%5CProjects%5C%5Cmatricula%5C%5Csrc%5C%5Cmain%5C%5Cresources%5C%5Capplication.properties%22%2C%22_sep%22%3A1%2C%22path%22%3A%22%2FD%3A%2FProjects%2Fmatricula%2Fsrc%2Fmain%2Fresources%2Fapplication.properties%22%2C%22scheme%22%3A%22file%22%7D%7D) esté configurado correctamente para MySQL, como se muestra en el fragmento de código proporcionado.

En el archivo `src/main/resources/application.properties`, asegúrate de incluir las siguientes configuraciones para que la base de datos se cree automáticamente junto con sus tablas y algunos datos de prueba:

```properties
# Configuración de MySQL Database
spring.datasource.url=jdbc:mysql://localhost:3306/db_matricula?createDatabaseIfNotExist=true
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create

# Opciones de inicialización de la base de datos
spring.sql.init.mode=always
spring.sql.init.continue-on-error=true
```

### Paso 3: Ejecución del Proyecto en IntelliJ IDEA

1. Abre **IntelliJ IDEA** y selecciona **Open** para abrir el proyecto clonado.
2. Verifica que **Java 17** esté seleccionado como JDK en el proyecto.
3. Dirígete a la clase `MatriculaApplication` ubicada en `src/main/java/pe/cibertec/matricula/MatriculaApplication.java`.
4. Haz clic en el botón **Run** para iniciar el proyecto.

La aplicación se ejecutará en el puerto **8080** por defecto. Puedes acceder a ella desde el navegador en `http://localhost:8080`.

### Verificación de la Base de Datos

Al iniciar la aplicación:

- La base de datos se crea automáticamente en memoria.
- Las tablas necesarias se generan con base en las entidades de JPA.
- Los datos de prueba definidos en `data.sql` se insertan automáticamente.

## Entidades y Relaciones

El proyecto incluye las siguientes entidades clave:

- **Alumno**: Representa a un alumno inscrito en la institución.
- **ConstanciaMatricula** y **ConstanciaReserva**: Representan constancias emitidas para matrícula y reserva, respectivamente.
- **OrdenPago** y **ComprobantePago**: Relacionadas con los pagos de matrícula, constancias y comprobantes.
- **Tesorero** y **ResponsableCaja**: Entidades relacionadas con la gestión de pagos.

Cada entidad tiene relaciones `@ManyToOne`, `@OneToMany` y `@OneToOne` según la estructura de negocio. Las entidades también están configuradas para crear automáticamente sus respectivas tablas en la base de datos.

## Generación de Reportes

El proyecto utiliza **JasperReports** para la generación de reportes en formato PDF. Puedes acceder a la funcionalidad de generación de reportes a través de los siguientes endpoints:

- **/reporte/generar**: Selección del tipo de reporte y generación del PDF.

El archivo `ReporteController` maneja la lógica para crear reportes específicos, y los archivos `.jrxml` en la carpeta `resources/reportes` definen el formato de cada reporte.

## Población de Datos de Ejemplo

Los datos iniciales para pruebas se encuentran en `data.sql` en la carpeta `resources`. Al iniciar el proyecto, este archivo se ejecuta automáticamente para poblar la base de datos con datos de ejemplo.

## Acceso a Endpoints Principales

- **Página Principal**: `http://localhost:8080`
- **Generación de Reportes**: `http://localhost:8080/reporte/generar`

## Estructura del Proyecto

Un ejemplo de la estructura del proyecto es la siguiente:

```
matricula/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pe/
│   │   │       └── cibertec/
│   │   │           └── matricula/
│   │   │               ├── controller/
│   │   │               │   ├── AlumnoController.java
│   │   │               │   ├── ConstanciaController.java
│   │   │               │   ├── OrdenPagoController.java
│   │   │               │   └── ReporteController.java
│   │   │               ├── entity/
│   │   │               │   ├── Alumno.java
│   │   │               │   ├── ConstanciaMatricula.java
│   │   │               │   ├── ConstanciaReserva.java
│   │   │               │   ├── OrdenPago.java
│   │   │               │   ├── ComprobantePago.java
│   │   │               │   ├── Tesorero.java
│   │   │               │   └── ResponsableCaja.java
│   │   │               ├── repository/
│   │   │               │   ├── AlumnoRepository.java
│   │   │               │   ├── ConstanciaRepository.java
│   │   │               │   ├── OrdenPagoRepository.java
│   │   │               │   └── ComprobantePagoRepository.java
│   │   │               ├── service/
│   │   │               │   ├── AlumnoService.java
│   │   │               │   ├── ConstanciaService.java
│   │   │               │   ├── OrdenPagoService.java
│   │   │               │   └── ReporteService.java
│   │   │               └── MatriculaApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── data.sql
│   │   │   └── reportes/
│   │   │       └── reporte.jrxml
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/
│   │               ├── index.html
│   │               ├── alumno/
│   │               │   ├── form.html
│   │               │   └── list.html
│   │               ├── constancia/
│   │               │   ├── form.html
│   │               │   └── list.html
│   │               ├── ordenpago/
│   │               │   ├── form.html
│   │               │   └── list.html
│   │               └── reporte/
│   │                   └── generar.html
│   └── test/
│       └── java/
│           └── pe/
│               └── cibertec/
│                   └── matricula/
│                       └── MatriculaApplicationTests.java
├── .gitignore
├── README.md
└── pom.xml
```

Esta estructura organiza el código fuente, recursos, y configuraciones del proyecto de manera clara y modular.

## Notas Finales

- Si realizas cambios en las entidades o deseas probar nuevas estructuras, recuerda actualizar `data.sql` y reiniciar la aplicación para ver los cambios reflejados.
- Puedes modificar `spring.jpa.hibernate.ddl-auto=create-drop` a `update` si deseas mantener los datos entre reinicios sin necesidad de recrear las tablas.

## Contribuciones

Si deseas contribuir a este proyecto, eres bienvenido a hacer un fork y enviar pull requests. ¡Gracias por colaborar!

## Integrantes del Proyecto

- **Paul Michael Vairo Lora** - I202335261 (Lead FullStack)
- **Omar Alonso Ruiz Zumaeta** - I202333548 (FullStack)
- **Patrick Javier Muñante Loayza** - I202335580 (FullStack)

---
