# SPMS - Smart Parking Management System

A microservices-based smart parking management system built with Spring Boot 4.1.0 and Java 17.

## Architecture

| Service | Description |
|---------|-------------|
| **Eureka Server** | Service discovery and registration |
| **Config Server** | Centralized configuration management |
| **API Gateway** | Single entry point, routing & load balancing |
| **User Service** | User registration and authentication |
| **Vehicle Service** | Vehicle registration and management |
| **Car Parking Service** | Parking slot allocation and tracking |
| **Payment Service** | Payment processing and billing |

## Tech Stack

- Java 17
- Spring Boot 4.1.0
- Spring Cloud (Eureka, Config, Gateway)
- Maven

## Getting Started

1. Start **Config Server** first
2. Start **Eureka Server**
3. Start remaining services in any order
4. Access API Gateway at the configured port

## Project Structure

```
├── api-gateway/
├── car-parking-service/
├── config-server/
├── eureka-server/
├── payment-service/
├── spms-config-repository/
├── user-service/
└── vehicle-service/
```

                         ┌──────────────────────────────┐
                         │       Client Application      │
                         │                              │
                         │       Next.js 15 Frontend    │
                         └──────────────┬───────────────┘
                                        │
                                        ▼
                         ┌──────────────────────────────┐
                         │         API GATEWAY           │
                         │      Spring Cloud Gateway     │
                         │          Port: 8080           │
                         │                              │
                         │ • Routing                    │
                         │ • CORS                       │
                         │ • JWT Authentication         │
                         │ • Request Filtering          │
                         └──────────────┬───────────────┘
                                        │
                ┌───────────────────────┼───────────────────────┐
                │                       │                       │
                ▼                       ▼                       ▼
       ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
       │   USER SERVICE  │    │ PARKING SERVICE │    │ PAYMENT SERVICE │
       │   Spring Boot   │    │   Spring Boot   │    │   Spring Boot   │
       │                 │    │                 │    │                 │
       │ • Users         │    │ • Parking Lots  │    │ • Payments      │
       │ • Roles         │    │ • Parking Slots │    │ • Transactions  │
       │ • Authentication│    │ • Availability  │    │ • Payment State │
       └────────┬────────┘    └────────┬────────┘    └────────┬────────┘
                │                      │                      │
                ▼                      ▼                      ▼
          ┌──────────┐           ┌──────────┐           ┌──────────┐
          │  MySQL   │           │  MySQL   │           │  MySQL   │
          │ user_db  │           │parking_db│           │payment_db│
          └──────────┘           └──────────┘           └──────────┘


                         ┌───────────────────────────┐
                         │    RESERVATION SERVICE    │
                         │       Spring Boot         │
                         │                           │
                         │ • Reservations             │
                         │ • Booking Management       │
                         │ • Reservation Status       │
                         └─────────────┬─────────────┘
                                       │
                                       ▼
                                ┌─────────────┐
                                │    MySQL    │
                                │reservation_db│
                                └─────────────┘


        ┌────────────────────────────────────────────────────┐
        │                 EUREKA SERVER                       │
        │              Netflix Eureka                         │
        │                  Port: 8761                         │
        │                                                    │
        │       Service Registration & Discovery              │
        └────────────────────────┬───────────────────────────┘
                                 │
                                 ▼
        ┌────────────────────────────────────────────────────┐
        │                 CONFIG SERVER                       │
        │            Spring Cloud Config                      │
        │                  Port: 8888                         │
        │                                                    │
        │           Centralized Configuration                 │
        │                                                    │
        │        GitHub Configuration Repository              │
        └────────────────────────────────────────────────────┘.

Infrastructure Flow
                    ┌─────────────────────┐
                    │    postman   │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     API Gateway     │
                    │       :8080         │
                    └──────────┬──────────┘
                               │
              ┌────────────────┼────────────────┐
              │                │                │
              ▼                ▼                ▼
          User Service   Parking Service   Payment Service
              │                │                │
              └────────────────┼────────────────┘
                               │
                        Reservation Service


        ┌──────────────────────────────────────┐
        │            Eureka Server              │
        │               :8761                   │
        │       Service Registration            │
        └──────────────────────────────────────┘

        ┌──────────────────────────────────────┐
        │           Config Server               │
        │               :8888                   │
        │      Centralized Configuration        │
        └──────────────────────────────────────┘
                         │
                         ▼
                  GitHub Repository

2. Microservices
User Service

Responsible for:

User registration
User login
User management
Role management
Password encryption
JWT authentication

Database:

user_db
Parking Service

Responsible for:

Parking locations
Parking slots
Slot availability
Parking management
Parking status

Database:

parking_db
Reservation Service

Responsible for:

Creating reservations
Managing bookings
Reservation status
Checking reservation availability
Managing user parking reservations

Database:

reservation_db
Payment Service

Responsible for:

Payment processing
Payment records
Transaction management
Payment status

Database:

payment_db


Backend
Java 21
Spring Boot
Spring Cloud
Spring Data JPA
Hibernate
Spring Security
JWT
Microservices Infrastructure
Spring Cloud Gateway
Spring Cloud Config
Netflix Eureka
Database
MySQL
Development & Testing
Git
GitHub
Postman
IntelliJ IDEA
VS Code
Maven
4. Communication Architecture

The client does not directly communicate with individual microservices.

All external requests go through the API Gateway.

Client
  │
  ▼
API Gateway :8080
  │
  ├──► User Service
  │
  ├──► Parking Service
  │
  ├──► Reservation Service
  │
  └──► Payment Service

The gateway uses Eureka Service Discovery to locate services.

API Gateway
     │
     ▼
Eureka Server :8761
     │
     ├── User Service
     ├── Parking Service
     ├── Reservation Service
     └── Payment Service

5. Configuration Management

Your project uses Spring Cloud Config Server for centralized configuration.

                    Config Server
                       :8888
                          │
                          ▼
                 GitHub Config Repository
                          │
          ┌───────────────┼────────────────┐
          ▼               ▼                ▼
     User Config    Parking Config    Payment Config

Example configuration files:

user-service.properties
parking-service.properties
reservation-service.properties
payment-service.properties

This prevents every service from maintaining duplicated configuration independently.

6. Service Discovery

Each microservice registers itself with Eureka.

                    Eureka Server
                       :8761
                          │
       ┌──────────────────┼──────────────────┐
       ▼                  ▼                  ▼
 User Service      Parking Service     Payment Service
       │
       └──────────── Reservation Service

This allows services to communicate using service names rather than hardcoded IP addresses and ports.

7. Database Architecture

Use a database-per-service approach.

User Service
     │
     ▼
  user_db




Parking Service
     │
     ▼
 parking_db




Reservation Service
     │
     ▼
reservation_db




Payment Service
     │
     ▼
 payment_db
     

                  

        
