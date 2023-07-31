#
# Build stage
#
FROM maven:3.6-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/dziennikocen-0.0.1-SNAPSHOT.jar dziennikocen-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","dziennikocen-0.0.1-SNAPSHOT.jar"]