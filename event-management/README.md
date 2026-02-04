# Event Management API

Spring Boot REST API for creating, reading, updating, and deleting events. Includes OpenAPI/Swagger documentation.

## Features
-Create, read, update, delete events
-RESTful API design
-Centralized exception handling
-SLF4J + Log4j2 logging
-Unit & integration testing
-Easy to extend with Swagger or database changes

## Tech Stack
-Java: 21
-Spring Boot: 3.3.2
-Spring Data JPA
-Hibernate
-MySQL (runtime)
-H2 (testing)
-JUnit 5
-Mockito
-Log4j2
-Maven

## Getting Started

### Requirements
- Java 21+
- Maven 3.9+ (or use the Maven wrapper `./mvnw`)

### Run
```bash
./mvnw spring-boot:run
```

API base URL: `http://localhost:8080/api/events`

Swagger UI: `http://localhost:8080/swagger-ui/index.html`

### Test
```bash
./mvnw test
```

## API Endpoints

| Method | Endpoint              | Description         |
|--------|-----------------------|---------------------|
| POST   | /api/events           | Create event        |
| GET    | /api/events/{id}      | Get event by id     |
| GET    | /api/events           | List all events     |
| PUT    | /api/events/{id}      | Update event        |
| DELETE | /api/events/{id}      | Delete event        |

## Event Schema
```json
{
  "id": 1,
  "title": "Tech Meetup",
  "description": "Monthly meetup",
  "location": "New York",
  "startTime": "2026-02-10T17:00:00Z",
  "endTime": "2026-02-10T19:00:00Z"
}
```

## Validation Rules
- `title` is required
- `location` is required
- `startTime` and `endTime` are required
- `endTime` must be after `startTime`

## Error Response Format
```json
{
  "message": "Event not found with id 99"
}

```

## Example Requests

Create an event:
```bash
curl -X POST http://localhost:8080/api/events \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Conference",
    "location": "Hyderabad",
    "date": "2026-03-15",
    "organizer": "Event Corp"
  }'

```

Get an event by id:
```bash
curl http://localhost:8080/api/events/1
```

List events:
```bash
curl http://localhost:8080/api/events
```

Update an event:
```bash
curl -X PUT http://localhost:8080/api/events/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Conference",
    "location": "Bangalore",
    "date": "2026-04-10",
    "organizer": "Updated Corp"
  }'

```

Delete an event:
```bash
curl -X DELETE http://localhost:8080/api/events/1
```

## Logging

-Implemented using SLF4J + Log4j2
-Logs written to:
-Console
-logs/event-management.log

## Log Levels Used

INFO – Business flow
DEBUG – Internal operations
WARN – Destructive actions
ERROR – Exceptions