FROM openjdk
ADD target/trip-plan-microservice.jar trip-plan-microservice.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "trip-plan-microservice.jar"]