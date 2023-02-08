FROM amazoncorretto:17
COPY target/file-reader-app-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]