FROM eclipse-temurin:11
COPY target/*.jar /app.jar

ENV USERNAME "postgres"
ENV PASSWORD "mysecretpassword"
ENV URL "jdbc:postgresql://localhost:5432/postgres" CAMBIAR LA URL DE LOCALHOST POR LA IP DE LA COMPUTADORA
Y HABILITAR EL PUERTO 8080 ANTES DE EJECUTAR EL SPIRNG BOOT

ENTRYPOINT ["java","-jar","/app.jar"]