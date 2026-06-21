README.md

Something like:

Library Management API
Features
User Registration
Login Authentication
JWT Security
Role Based Authorization
Book Management CRUD
Spring Security
MySQL Integration
Docker Containerization
Tech Stack
Java 17
Spring Boot
Spring Security
Spring Data JPA
MySQL
Docker
Maven
Run Using Docker
docker build -t library-api .
docker run -p 9090:9090 library-api
API Endpoints
Method	Endpoint
POST	/auth/register
POST	/auth/login
GET	/books
POST	/books
PUT	/books/{id}
DELETE	/books/{id}
