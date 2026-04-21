Ecommerce Backend — Microservices Architecture

This project is a microservices-based e-commerce backend.
It is divided into two independent services:

This service itself is Auth Service — handles user registration and login.
After successful login, a JWT token is generated.
GitHub link: https://github.com/prakriti2209/Ecommerce-project

Product Service — handles product management.
Admin can add, update, delete products.
Users can view all products.
Every request requires a valid JWT token in the Authorization header.
GitHub link: https://github.com/prakriti2209/ProductService

How these services work together:
1. User registers and logs in via Auth Service on port 8077
2. Auth Service returns a JWT token
3. User sends that token in every Product Service request
4. Product Service verifies the token and allows or blocks access

Tech used: Java, Spring Boot, Spring Security, JWT, MySQL, Postman
