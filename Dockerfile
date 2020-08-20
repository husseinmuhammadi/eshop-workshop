FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /shop-src
COPY ./ ./
RUN mvn -f parent package -DskipTests


FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/web-app/target/cms-webapp-1.0.0-SNAPSHOT.jar /app/cms.jar
ENTRYPOINT ["java","-jar","/app/cms.jar"]