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


        
