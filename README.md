E-commerce Backend System

A microservices-based e-commerce backend built with Spring Boot.

Services
 **Auth Service** — User registration and login with JWT token generation
 **Product Service** — Admin can add/update/delete products; users can browse all products (role-based access)
 **Order Service** — Users can place and view their own orders

 Tech Stack
 Java, Spring Boot, Spring Security
 JWT Authentication- MySQL, Spring Data JPA, Hibernate
 REST APIs
 Postman (for testing)

 How to Run
1. Clone the repository
2. Set up MySQL and update `application.properties` with your DB credentials
3. Run each service separately using `mvn spring-boot:run`
4. Test APIs using Postman

API Endpoints (Auth Service)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register new user |
| POST | /auth/login | Login and get JWT token |
