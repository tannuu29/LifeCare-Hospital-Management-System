# LifeCare Hospital Management System (Backend)
This is the backend service for LifeCare Hospital Management System, built using Spring Boot.
It provides RESTful APIs for managing hospital operations like patients, doctors, appointments, and billing.

---

## Features
-	Patient registration, update, and retrieval
-	Doctor management with specialization details
-	Appointment booking and scheduling
-	Billing and invoice management
-	Database integration using Spring Data JPA

---

## Technologies Used
	•	Java 17+
	•	Spring Boot 3+
	•	Spring Data JPA & Hibernate
	•	MySQL (or your DB)
	•	Lombok
	•	Maven

 ---

## Setup & Installation
### Prerequisites
	•	Java 17+ installed
	•	MySQL database running
	•	Maven installed

 ### Follow these steps to set up the **LifeCare Hospital Management System** locally:
#### 1.	Clone the repository: 
     ```bash
     git clone https://github.com/tannuu29/LifeCare-Hospital-Management-System.git  
#### 2.	Navigate into the project folder:
      cd LifeCare-Hospital-Management-System
#### 3.	Configure the database in src/main/resources/application.properties:
    server.port =80
    spring.datasource.url=jdbc:mysql://localhost:3306/lifeCare?createDatabaseIfNotExist=true
    spring.datasource.username=your_username
    spring.datasource.password=your_password

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

#### 4.	Run the application.
    Start the backend server on http://localhost
---

  
