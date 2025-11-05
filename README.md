# tp---Fundamentos-Spring-Boot
Descripción del proyecto

Este proyecto es un trabajo práctico desarrollado con el fin de poner en práctica los fundamentos de Spring Boot.
La aplicación incluye configuración de distintos profiles (por ejemplo dev y prod), permite observar cómo varían los comportamientos, las propiedades, los entornos, y sirve como base para comprender el ciclo de vida de una aplicación Spring Boot en entornos reales.

Principales objetivos:

Poner en marcha una aplicación Spring Boot minimalista que incluya configuración por profile.

Mostrar el uso de propiedades externas (archivo application-*.yml o application-*.properties) para distintos entornos.

Permitir al usuario clonar el proyecto, cambiar de perfil, arrancar la aplicación y ver la diferencia entre dev y prod.

Servir como base para futuras ampliaciones (persistencia, servicios, APIs, etc).

Tecnologías utilizadas

Java 17 (o la versión que hayas configurado)

Spring Boot (versión especificada en el pom.xml)

Maven como gestor de dependencias y herramienta de construcción

Archivos de configuración application-dev.yml y application-prod.yml (o .properties) para los distintos profiles

(Opcional) Otros módulos de Spring que estés usando: Web, Data, etc.

(Opcional) IDE sugerido: IntelliJ IDEA, Eclipse, VSCode

Git y GitHub para el control de versiones y alojamiento del código

Instrucciones para clonar y ejecutar

Clonar el repositorio:

git clone https://github.com/nikitoh33/tp---Fundamentos-Spring-Boot.git  
cd tp---Fundamentos-Spring-Boot  


Abrir el proyecto en tu IDE favorito o desde la línea de comandos.

Construir el proyecto (con Maven):

./mvnw clean install  


(O en Windows: mvnw.cmd clean install)

Ejecutar la aplicación con el profile que desees (ver sección siguiente).

Abrir un navegador o cliente HTTP para acceder al endpoint principal (por ejemplo http://localhost:8080/ u otro que hayas configurado) y observar la salida según el perfil.

Cómo cambiar entre profiles

Para ejecutar la aplicación bajo un profile específico (dev, prod, u otro que hayas definido), puedes hacerlo de las siguientes maneras:

Mediante línea de comandos:

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev  


o

java -jar target/tu-aplicación.jar --spring.profiles.active=prod  


O bien configurarlo en tu IDE (por ejemplo, en la configuración de ejecución añadir -Dspring.profiles.active=prod).

También puedes definir el profile por variable de entorno:

export SPRING_PROFILES_ACTIVE=dev  


y luego ejecutar normalmente.

Al activar el profile dev, se cargarán las propiedades definidas en application-dev.yml (o .properties) y al activar prod, las definidas en application-prod.yml. Esto permite cambiar fácilmente detalles como puerto, URL de base de datos, modo de logging, etc.

Capturas de pantalla

A continuación coloca dos capturas de pantalla: una que muestre la ejecución de la aplicación con profile dev, y otra con profile prod. Asegúrate de que se vean claramente: el nombre del profile activo (en la consola o en la URL), algún mensaje distintivo de cada entorno (por ejemplo “Modo DEV” o “Modo PROD”) y que se muestre el endpoint funcionando correctamente.

(Aquí inserta las capturas: “screenshot-dev.png”, “screenshot-prod.png” o como prefieras)

Conclusiones personales

En este proyecto he podido afianzar conceptos clave de Spring Boot, especialmente el trabajo con perfiles de entorno, manejo de propiedades externas y la modularidad para entornos de desarrollo y producción. He aprendido que tener perfiles bien definidos facilita la configuración y el despliegue de aplicaciones en distintos contextos, y que anticipar la separación entre dev y prod puede ahorrar muchos problemas en el ciclo de vida de desarrollo.

Además, este trabajo sirve como base para futuras extensiones: añadir persistencia (por ejemplo con Spring Data JPA), exponer APIs REST, gestionar seguridad, etc. Lo que más me quedó claro es que la estructura de perfiles no sólo es una cuestión de configuración, sino de buenas prácticas arquitectónicas para diferenciar entornos sin cambiar código.
