# Job Application Tracker

A Spring Boot REST API for managing job applications.

## Features

- Create a new job application
- View all applications
- View an application by ID
- Update an existing application
- Delete an application
- Filter applications by status
- Validate required fields
- Return 404 when an application is not found

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit 5
- Maven

## Project Structure

- `controller` - handles HTTP requests
- `service` - contains business logic
- `repository` - handles database access
- `model` - contains the application entity and status enum
- `exception` - handles custom exceptions

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/applications` | Get all applications |
| GET | `/applications/{id}` | Get one application by ID |
| POST | `/applications` | Create a new application |
| PUT | `/applications/{id}` | Update an application |
| DELETE | `/applications/{id}` | Delete an application |
| GET | `/applications/status/{status}` | Filter applications by status |

## Application Status

Available status values:

- `APPLIED`
- `INTERVIEW`
- `WAITING`
- `REJECTED`
- `OFFER`

## Example Request

{
  "company": "Siemens",
  "position": "Software Intern",
  "applicationDate": "2026-09-23",
  "status": "APPLIED",
  "note": "Applied online"
}

## Validation

`company` and `position` must not be blank.

## Testing

The project includes JUnit tests for:

- Adding applications
- Finding applications by ID
- Updating applications
- Deleting applications
- Handling missing IDs
- Filtering by status

## Run the Project

Run the Spring Boot application from:

`ApplicationtrackerApplication.java`

or use Maven:

```bash
./mvnw spring-boot:run
```

The API will run at:
`http://localhost:8080`

