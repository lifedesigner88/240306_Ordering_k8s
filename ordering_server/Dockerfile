FROM openjdk:11 as stage1

WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
ARG DB_HOST
ARG DB_USERNAME
ARG DB_PASSWORD
ENV DB_HOST=${DB_HOST}
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}


FROM openjdk:11

WORKDIR /app

COPY --from=stage1 /app/build/libs/*.jar app.jar

VOLUME /tmp

ENTRYPOINT [ "java", "-jar", "app.jar" ]

