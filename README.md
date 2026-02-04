Event Management API

Spring Boot REST API for creating, reading, updating, and deleting events.
Built using Spring Boot 3, follows layered architecture, includes logging and unit testing.

 Features

Create, read, update, delete events

RESTful API design

Centralized exception handling

SLF4J + Log4j2 logging

Unit & integration testing

Easy to extend with Swagger or database changes

 Tech Stack

Java: 21

Spring Boot: 3.3.2

Spring Data JPA

Hibernate

MySQL (runtime)

H2 (testing)

JUnit 5

Mockito

Log4j2

Maven

 Getting Started
Requirements

Java 21+

Maven 3.9+

Run Application
mvn spring-boot:run


API Base URL:

http://localhost:8080/api/events

Run Tests
mvn test

 API Endpoints
Method	Endpoint	Description
POST	/api/events	Create event
GET	/api/events/{id}	Get event by ID
GET	/api/events	List all events
PUT	/api/events/{id}	Update event
DELETE	/api/events/{id}	Delete event
 Event Schema
{
  "id": 1,
  "name": "Tech Conference",
  "location": "Hyderabad",
  "date": "2026-03-15",
  "organizer": "Event Corp"
}

 Validation Rules

name is required

location is required

date is required

organizer is required

 Error Response Example
{
  "message": "Event not found with id 99"
}

 Example Requests
Create Event
curl -X POST http://localhost:8080/api/events \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Conference",
    "location": "Hyderabad",
    "date": "2026-03-15",
    "organizer": "Event Corp"
  }'

Get Event by ID
curl http://localhost:8080/api/events/1

List All Events
curl http://localhost:8080/api/events

Update Event
curl -X PUT http://localhost:8080/api/events/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Conference",
    "location": "Bangalore",
    "date": "2026-04-10",
    "organizer": "Updated Corp"
  }'

Delete Event
curl -X DELETE http://localhost:8080/api/events/1

 Testing Strategy

Controller Tests → MockMvc

Service Tests → Mockito

Repository Tests → H2 in-memory DB

 Logging

Implemented using SLF4J + Log4j2

Logs written to:

Console

logs/event-management.log

Log Levels Used

INFO – Business flow

DEBUG – Internal operations

WARN – Destructive actions

ERROR – Exceptions
