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
| Framework          | Spring Boot, Spring MVC, Spring Security              |
| Databases          | MySQL, MongoDB, Elasticsearch                         |
| Messaging          | Apache Kafka                                           |
| Caching            | Redis                                                  |
| Security           | JWT, OAuth2                                            |
| DevOps             | Docker, AWS EC2, AWS RDS                               |
| Tools              | Postman, Maven, Git, GitHub                            |

---

## 📁 Project Structure

