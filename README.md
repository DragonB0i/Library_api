# Library API 📚

A RESTful backend application built using Spring Boot, Spring Security, JWT Authentication, MySQL, and Docker.

This project provides a secure Library Management API that allows users to manage books while implementing role-based authentication and authorization.

## Features

### Authentication & Security

* User Registration
* User Login
* JWT-based Authentication
* Password Encryption using BCrypt
* Role-based Authorization
* Protected API Endpoints

### Book Management

* Add New Books
* Retrieve All Books
* Retrieve Book by ID
* Update Book Information
* Delete Books
* Search and Manage Library Records

### Database

* MySQL Integration
* Spring Data JPA
* Hibernate ORM
* Automatic Schema Updates

### Deployment

* Dockerized Spring Boot Application
* Containerized Runtime Environment
* Portable Deployment Across Systems

---

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Docker

---

## Project Structure

src/
├── controller/
├── service/
├── repository/
├── model/
├── security/
├── config/
└── dto/

---

## API Endpoints

### Authentication

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /auth/register | Register User     |
| POST   | /auth/login    | Authenticate User |

### Books

| Method | Endpoint    | Description    |
| ------ | ----------- | -------------- |
| GET    | /books      | Get All Books  |
| GET    | /books/{id} | Get Book By ID |
| POST   | /books      | Add Book       |
| PUT    | /books/{id} | Update Book    |
| DELETE | /books/{id} | Delete Book    |

---

## Running Locally

### Clone Repository

git clone <repository-url>

cd library-api

### Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/library_db

spring.datasource.username=root

spring.datasource.password=your_password

### Build Project

mvn clean install

### Run Application

mvn spring-boot:run

---

## Docker Deployment

Build Docker Image:

docker build -t library-api .

Run Container:

docker run -d -p 9090:9090 library-api

---

## Learning Outcomes

Through this project, I gained hands-on experience with:

* Building REST APIs using Spring Boot
* Implementing JWT Authentication
* Securing endpoints with Spring Security
* Database integration using JPA/Hibernate
* Containerization using Docker
* Backend application deployment concepts
* API testing and debugging

---

## Future Improvements

* Refresh Tokens
* Pagination & Sorting
* Swagger/OpenAPI Documentation
* Unit & Integration Testing
* Docker Compose Support
* Cloud Deployment (AWS / Render / Railway)

---

## Author

Vanessa Nick

Backend Developer | Java | Spring Boot | MySQL | Docker
