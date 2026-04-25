# Mental Health Risk Index Service

An event-driven system for aggregating data from external sources and calculating a composite risk score.

This project demonstrates building a data pipeline using Kafka, microservices architecture, and real-time data processing.

---

## 🚀 Overview

The system collects data from multiple external sources (e.g., weather, news), processes it through Kafka, and computes an aggregated risk index.

---

## 🧱 Architecture

The system is built as an event-driven pipeline:

[External APIs] 
      ↓
[Ingestion Service] → Kafka → [Scoring Service] → PostgreSQL
                                         ↓
                                   (API Service)

### Components

- **Ingestion Service**
  - Fetches data from external APIs
  - Transforms it into events
  - Publishes events to Kafka

- **Kafka**
  - Acts as a message broker and buffer
  - Decouples ingestion and processing layers
  - Enables replay of events

- **Scoring Service**
  - Consumes events from Kafka
  - Aggregates incoming data
  - Calculates a risk score

- **PostgreSQL**
  - Stores aggregated results

- **API Service (optional)**
  - Exposes results to external consumers

---

## ⚙️ Tech Stack

- Kotlin (JVM) + Java 21 toolchain  
- Spring Boot / Spring Cloud  
- Apache Kafka  
- PostgreSQL  
- Docker / Docker Compose  
- (optional) Kubernetes  
- Prometheus + Grafana  

---

## 🔄 Event Flow

1. Ingestion Service fetches data from external APIs  
2. Transforms data into events  
3. Publishes events to Kafka  
4. Scoring Service consumes events  
5. Aggregates data and calculates risk score  
6. Stores results in PostgreSQL  

---

## 📦 Example Event

{
  "type": "weather_event",
  "location": "SPB",
  "temperature": -5,
  "timestamp": "2026-04-15T10:00:00Z"
}

---

## 🧠 Why Kafka?

Kafka is used to:

- Decouple ingestion and processing layers  
- Buffer and smooth incoming data flow  
- Enable event replay and reprocessing  
- Scale components independently  

---

## 📈 Key Features

- Event-driven architecture  
- Real-time data processing  
- Extensible design (new consumers can be added without changing ingestion)  
- Support for different processing speeds  

---

## 🛠️ Running the Project

docker-compose up --build

This will start:

- Kafka + Zookeeper  
- PostgreSQL  
- ingestion-service  
- scoring-service  

---

## 🔮 Future Improvements

- API Gateway  
- Retry mechanisms and dead-letter queues  
- Exactly-once semantics  
- Additional data sources  
- Monitoring with Prometheus/Grafana  

---

## 📌 Project Goal

Demonstrate skills in:

- Microservices architecture  
- Kafka and event-driven systems  
- Data processing and aggregation  
- Designing scalable backend services  
