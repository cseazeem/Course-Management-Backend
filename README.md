# Course Management Backend

This is the backend service for the Course Management application, developed using **Spring Boot**. It provides RESTful APIs for managing courses and course instances, supporting various operations like creating, retrieving, and deleting courses and instances.

## Features

- **RESTful APIs**: CRUD operations for courses and course instances.
- **PostgreSQL Integration**: Secure and efficient data storage.
- **Liquibase for Migrations**: Seamless database versioning and migration.
- **JDBI for Data Access**: Lightweight and flexible data access layer.
- **Role-Based Access Control**: Secure API access for different user roles.
- **Dockerized**: Easily deployable with Docker.
- **CI/CD Ready**: Integrated with GitHub Actions for automated builds.

## API Endpoints

### Courses

- **POST** `/api/courses` : Create a new course.
- **GET** `/api/courses` : List all available courses.
- **GET** `/api/courses/{id}` : View details of a specific course.
- **DELETE** `/api/courses/{id}` : Delete a specific course.

### Course Instances

- **POST** `/api/instances` : Create a new course instance.
- **GET** `/api/instances/{year}/{semester}` : List course instances for a specific year and semester.
- **GET** `/api/instances/{year}/{semester}/{id}` : View details of a course instance.
- **DELETE** `/api/instances/{year}/{semester}/{id}` : Delete a course instance.

## Prerequisites

- **Java 17** or later
- **PostgreSQL**
- **Docker**
- **Maven**

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/cseazeem/course-management-backend.git
   cd course-management-backend
