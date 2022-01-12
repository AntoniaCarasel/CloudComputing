FROM openjdk
ADD target/trip-planner-microservicve.jar trip-planner-microservicve.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "trip-planner-microservicve.jar"]