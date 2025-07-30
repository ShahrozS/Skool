# Use Amazon Corretto 18 with Alpine
FROM amazoncorretto:18-alpine

# Set the working directory
WORKDIR /app

# Install netcat (for checking DB readiness)
RUN apk add --no-cache netcat-openbsd

# Copy the JAR into the container
COPY target/*.jar app.jar

# Expose the Spring Boot port
EXPOSE 8080

# Wait for Postgres and then run the app
ENTRYPOINT ["sh", "-c", "\
  echo '⏳ Waiting for PostgreSQL to be ready...' && \
  until nc -z postgres 5432; do \
    echo '❌ Postgres not ready, retrying...'; \
    sleep 2; \
  done && \
  echo '✅ PostgreSQL is up! Starting the app...' && \
  java -jar app.jar"]
