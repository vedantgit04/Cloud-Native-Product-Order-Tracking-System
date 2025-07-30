# ☁️ Cloud-Native Product & Order Tracking System

A scalable, modular backend system built using Spring Boot and microservices architecture. This project simulates a production-grade backend for managing users, products, carts, orders, payments, and secure authentication. It uses modern tools like Kafka for async communication, Redis for caching, and is deployed on AWS.

---

## 🚀 Features

- ✅ User Registration, Login, and Profile Management (JWT & OAuth2)
- 🛒 Product Catalog with Fast Search (via Elasticsearch)
- 🛍️ Cart & Checkout Flow with Real-Time Updates
- 💳 Payment Service Integration with Kafka Notifications
- 📦 Order History and Status Tracking
- 🔒 Secure Authentication and Role-Based Access
- ⚙️ Asynchronous Communication using Apache Kafka
- ⚡ Redis Caching for Fast Cart Operations
- ☁️ Dockerized Microservices with AWS Deployment Support

---

## 🧱 Architecture Overview

- **Microservices**:
  - `User-Service`
  - `Product-Catalog-Service`
  - `Cart-Service`
  - `Order-Service`
  - `Payment-Service`
  - `Notification-Service`
- **Communication**: REST APIs + Kafka Events
- **Databases**: MySQL (structured), MongoDB (cart), Elasticsearch (search)
- **Security**: Spring Security + JWT + OAuth2
- **Caching**: Redis
- **DevOps**: Docker, AWS (EC2, RDS)

---

## 🧰 Tech Stack

| Category           | Tools & Technologies                                   |
|--------------------|--------------------------------------------------------|
| Language           | Java                                                   |
| Framework          | Spring Boot, Spring MVC, Spring Security               |
| Databases          | MySQL, MongoDB, Elasticsearch                          |
| Messaging          | Apache Kafka                                           |
| Caching            | Redis                                                  |
| Security           | JWT, OAuth2                                            |
| DevOps             | Docker, AWS EC2, AWS RDS                               |
| Tools              | Postman, Maven, Git, GitHub                            |

---

---

## 🔐 Security

- 🔑 Implemented **JWT-based authentication** to securely verify and authorize users.
- 🔐 Integrated **OAuth2** for third-party login support (e.g., Google).
- 🔒 Used **Spring Security** to manage role-based access control and secure API endpoints.
- 🔒 All passwords are securely hashed using **BCrypt**.
- 🛡️ Sessions and tokens are handled in a stateless manner for scalability and security.

---

## 🧪 Testing

- 🧪 Unit tests are written using **JUnit** and **Mockito** to validate service, repository, and controller layers.
- 🔄 Mocking external service calls ensures tests remain isolated and fast.
- ✅ Tested key components such as:
  - User authentication & registration flow
  - Product search and retrieval logic
  - Cart operations and checkout
  - Order lifecycle including Kafka-based triggers
- 💡 Follows **Test-Driven Development (TDD)** best practices in service layer logic.

---

## ☁️ Deployment

- 🐳 All services are **Dockerized** using individual `Dockerfile`s and managed via `docker-compose.yml`.
- ☁️ Deployed on **AWS EC2** instances for compute and **AWS RDS** for MySQL database.
- 📦 Redis and Kafka are either containerized locally or set up via managed cloud services.
- 🔐 Sensitive environment configurations and secrets are stored using `.env` files (not committed).
- 📶 Load balancing and service discovery are managed using tools like **Spring Cloud** and **API Gateway**.

---

## 📌 Future Improvements

- 🔁 Add **rate limiting** and **retry mechanisms** on Kafka consumers.
- 📊 Integrate **centralized logging and monitoring** (e.g., ELK stack, Prometheus, Grafana).
- 🔐 Use **Spring Cloud Gateway** and **Spring Config Server** for advanced API management.
- 📱 Integrate **push notifications** and SMS-based alerts.
- 🚀 Implement **CI/CD pipelines** with GitHub Actions or Jenkins.

---


## 🧑‍💻 Author

**Your Name**  
[LinkedIn](https://www.linkedin.com/in/vedant-dhole-05934824a/) • [GitHub](https://github.com/vedantgit04)

---






