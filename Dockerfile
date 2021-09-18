FROM gradle:7.2-jdk11 as build

WORKDIR /app

COPY . .

RUN ./gradlew test  && ./gradlew bootJar -x test

FROM openjdk:11-jdk as main

WORKDIR /app

COPY --from=build /app/build /app/build/

CMD java -jar /app/build/libs/*.jar
