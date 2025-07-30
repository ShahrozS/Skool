
# SKOOL

A back-end created using springboot and java with data JPA to write APIs that would
perform crud operations on the school managment tables. Created for Simplifi.

Postman collection with all the APIs and bodies has been already provided.




Database: PostgreSQL



Note: This is created for simplifi






## To Run

To run the application:

1. Clone or download the repository
2. Run these commands:
3. docker-compose down -v
4. docker-compose build --no-cache
5. docker-compose up.


Now the database container and my app container will run and then connect through the network.

Now just visit the postman collection and try out the application for yourself!

You can visit the swagger  url to visit the api documentation
http://localhost:8080/swagger-ui.html



## What am I providing with the application?


A fully dockerized, RESTful Spring Boot backend for managing a school system.
The app includes the following entities, each with complete CRUD functionality:

School

ClassRoom

Student

Teacher

Subject

Enrollment (to link Students to Subjects taught by Teachers)

Each entity is:

Properly annotated using JPA and follows a normalized relational database structure

Covered with service classes (no direct repository logic in controllers)

Documented using Swagger/OpenAPI for easy testing and understanding


## Testing


Unit tests have been written using JUnit 5 and Mockito.

Each service layer is tested with mocked repositories to ensure isolation and correctness.

Run this for test:
mvn clean test

