# Talent Flow: A Distributed Job Recruitment Platform

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen) ![Docker](https://img.shields.io/badge/Docker-blue) ![Kubernetes](https://img.shields.io/badge/Kubernetes-blue)

Talent Flow is a job recruitment platform built on a microservices architecture using Spring Boot and Spring Cloud. This project demonstrates a transition from a traditional monolithic design to a scalable, resilient, and observable cloud-native system.

## Key Features

* **Distributed & Resilient:** Built with Spring Cloud and Resilience4j, implementing patterns like Circuit Breakers, Retries, and Rate Limiting for fault-tolerant communication.
* **Centralized & Observable:** Manages configurations for all services via Spring Cloud Config Server and provides end-to-end distributed tracing with Zipkin and Micrometer.
* **Dynamic Routing & Discovery:** Uses a Spring Cloud Gateway as a single entry point and Eureka Server for dynamic service registration and discovery.
* **Asynchronous Communication:** Integrates RabbitMQ for asynchronous, event-driven communication between services, ensuring loose coupling and reliability.
* **Containerized:** Fully containerized with Docker and orchestrated with both Docker Compose and Kubernetes manifests for easy setup and scalable deployment.

## Technology Stack

* **Backend:** Java 17, Spring Boot, Spring Cloud, Spring Data JPA, Resilience4j, OpenFeign
* **DevOps:** Docker, Docker Compose, Kubernetes (MiniKube), Maven, Git
* **Databases & Messaging:** PostgreSQL, RabbitMQ, H2 Database
* **Observability & Service Mesh:** Eureka, Spring Cloud Gateway, Zipkin, Micrometer, Spring Boot Actuator

## Getting Started

### Prerequisites

* JDK 17+
* Docker & Docker Compose
* Maven
* An IDE like IntelliJ IDEA

### Running the Application

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/JayNehete/TalentFlow.git](https://github.com/JayNehete/TalentFlow.git)
    cd TalentFlow
    ```

2.  **Start Backing Services:**
    The `docker-compose.yml` file in the root directory defines all necessary backing services.
    ```bash
    docker-compose up -d
    ```
    This command will start PostgreSQL, PGAdmin, RabbitMQ, and Zipkin in detached mode.

3.  **Run Microservices from IDE:**
    Open the project in IntelliJ IDEA. The project is structured with multiple Maven modules for each microservice. Run the services in the following order:
    1.  `config-server`
    2.  `service-registry`
    3.  `company-ms`, `job-ms`, `review-ms`
    4.  `gateway-ms`

## API Endpoints

All requests are routed through the **API Gateway** running on `http://localhost:8084`.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/jobs` | Fetches all jobs. |
| `POST` | `/jobs` | Creates a new job. |
| `GET` | `/companies` | Fetches all companies. |
| `POST` | `/companies` | Creates a new company. |
| `GET` | `/reviews?companyId={id}` | Fetches reviews for a company. |

*For a full list of endpoints, please refer to the controller classes within each microservice module.*
