For both User Service and Journal Service, add Swagger dependencies to pom.xml.
<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-ui</artifactId>
<version>1.6.14</version>
</dependency>
Swagger will automatically scan your REST controllers and expose the documentation at /swagger-ui.html.

No additional configuration is necessary, but you can add custom descriptions and tags for better readability if needed.

Spring Boot Microservices: User Service & Journal Service
This project contains two Spring Boot microservices:

User Service: Responsible for user management (CRUD operations).

Journal Service: Consumes user events (published by User Service) and stores journal entries.

The system leverages:

. Kafka for messaging.

.Spring Security for role-based access control.

PostgreSQL as the database.

Docker and Docker Compose for containerization.

Architecture
User Service:
Manages user registration, retrieval, update, and deletion.
Publishes user-related events (like registration, update, and deletion) to a Kafka topic (user-events).
Journal Service:
Listens to the user-events topic and logs the events in a journal.
Exposes endpoints to retrieve stored journal entries.

Pre-requisites
Ensure you have the following installed:

Docker and Docker Compose
JDK 17 or newer (for local development)
Maven (to build the services)

https://github.com/soumyadip-26/java-assignment-epica