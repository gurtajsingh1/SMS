# Student Management System (SMS)

A full-stack Student Management System built with Spring Boot, Thymeleaf, and MySQL.

## Features
- Add, View, and Delete Students
- Modern UI with responsive design
- MySQL database integration
- RESTful API endpoints

## Prerequisites
- Java 21+
- Maven
- MySQL Server

## Setup

### 1. MySQL Setup
Make sure MySQL is running and create a database (or let the app create it automatically):
```sql
CREATE DATABASE sms_db;
```

### 2. Database Configuration
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sms_db
spring.datasource.username=root
spring.datasource.password=root  # Change to your MySQL password
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```

### 4. Access the Application
Open your browser: http://localhost:8080

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| POST | /students | Create student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## Project Structure
```
src/
├── main/
│   ├── java/com/message/SMS/
│   │   ├── Controller/
│   │   │   ├── Studentcontroller.java  (REST API)
│   │   │   └── ViewController.java     (Thymeleaf views)
│   │   ├── Model/
│   │   │   └── Student.java
│   │   ├── Repository/
│   │   │   └── StudentRepository.java
│   │   ├── Service/
│   │   │   └── StudentService.java
│   │   └── SmsApplication.java
│   └── resources/
│       ├── application.properties
│       └── templates/
│           └── index.html
└── pom.xml
```

