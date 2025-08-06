# 🚍 Public Transit Fleet Management System (PTFMS)

A Java-based web application designed to help public transit agencies manage, track, and optimize the operations of their vehicles, including buses, electric light rail, and diesel-electric trains.

---

## 📌 Project Overview

The **Public Transit Fleet Management System (PTFMS)** is built as a 3-tier architecture solution (Presentation, Business, and Data layers) to provide:

- Real-time GPS tracking
- Energy and fuel usage monitoring
- Predictive maintenance alerts
- Route assignment and reporting
- Role-based access control for Transit Managers and Operators

This system is developed using **Java 21**, **Java Servlets**, **MySQL 8.0.40**, and deployed on **Apache Tomcat 9.0.90+**.

---

## 🛠️ Technologies & Design Patterns

### Core Technologies:

- Java 21 and Java Servlets
- MySQL 8.0.40 (Database)
- Apache Tomcat 9.0.90 (or later)

### Design Patterns Implemented:

- **DAO (Data Access Object)**
- **Builder Pattern**
- Additional 4 Patterns:
  - Strategy
  - Simple Factory
  - Adapter
  - Observer

---

## ✅ Functional Requirements

### FR-01: User Registration & Authentication

- Role-based registration: Transit Manager and Operator
- Secure login/logout functionality

### FR-02: Vehicle Management

- Vehicle registration (type, number, capacity, route)
- Fuel/Energy attributes

### FR-03: GPS Tracking

- Real-time location tracking
- Manual out-of-service logging

### FR-04: Monitoring Fuel/Energy Consumption

- Usage reporting by vehicle type
- Alerts for over-consumption

### FR-05: Predictive Maintenance Alerts

- Monitors wear hours and diagnostics
- Maintenance scheduling

### FR-06: Reporting & Analytics

- Dashboards: vehicle performance, operator efficiency, costs

---

## 🧪 Testing

- Unit Testing with **JUnit**
- Manual testing with sample data (SQL file included)
- Test plan detailed in the High-Level Design document

---

## 📈 Deliverables

- High-Level Design document (architecture, UMLs, test plan)
- Complete Source Code in Maven-compatible structure
- SQL scripts and sample data
- Presentation slides (for demo)
- GitHub repository with activity tracking and branch management
- Final Peer Review documentation

---

## 📣 Authors

- Sreelakshmi Manoj – Student ID: 041141760 @
- Deepanshu – Student ID: 041155408 @Deep0022
- Ramandeep Kaur – Student ID: 041151322 @Ramandeep59
- Viet-Quynh Nguyen – Student ID: 041088250 @r3ssler
