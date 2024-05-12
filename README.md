# Prueba Práctica Periferia - Backend

Este proyecto consiste en un servicio HTTP, construida con Spring boot con Java jdk (17.0.10) y Maven (3.9.6) en el backend.

## Instalación y Configuración

1. Clona este repositorio.
2. Instala las dependencias: `mvn install`
3. Inicia el build del jar: `mvn package`
4. Inicia el servidor: `java -jar ./target/periferia-back-0.0.1-SNAPSHOT.jar`

El backend se encarga de obtener los datos de un usuario en base a su tipo de documento y su numero de documento.

## Uso

Una vez que el servidor están en ejecución, puedes acceder a la api en `http://localhost:8090/usuarios/`.

## Documentación de APIs

La documentación de las APIs expuestas por el backend se encuentra disponible mediante Swagger. Puedes acceder a la documentación en `http://localhost:8090/swagger-ui/index.html` una vez que el servidor está en ejecución.

## Pruebas

Se incluyen pruebas unitarias para el backend. Para ejecutar las pruebas, utiliza el siguiente comando: `mvn test`

## Contacto

Si tienes alguna pregunta o comentario sobre este proyecto, no dudes en contactarme:

- Nombre: Ricardo Mantilla
- Correo electrónico: mantillasanchezr@gmail.com
