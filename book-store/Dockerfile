FROM maven:3-openjdk-8-slim AS maven
WORKDIR /app
COPY pom.xml .
RUN #mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean package -DskipTests=true


FROM openjdk:8-jdk-alpine
COPY --from=maven /app/target/*.jar app.jar

ENV SW_AGENT_COLLECTOR_BACKEND_SERVICES="host.docker.internal:11800" \
    SW_AGENT_NAME="book-store"

COPY skywalking-agent /usr/local/agent    

EXPOSE 9000
ENTRYPOINT ["sh", "-c", "java -javaagent:/usr/local/agent/skywalking-agent.jar=agent.service_name=book-store -jar app.jar"]


