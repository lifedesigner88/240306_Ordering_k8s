FROM openjdk:11 as stage1

WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:11

WORKDIR /app

COPY --from=stage1 /app/build/libs/*.jar app.jar

VOLUME /tmp

ENTRYPOINT [ "java", "-jar", "app.jar" ]

