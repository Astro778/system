# Mega Project

## Project Overview
**Mega Project** is a Java Spring Boot application designed for managing a robust data system via REST APIs.  
This repository contains all necessary source files, configurations, and dependencies to execute the server in a production-like environment.  

The project emphasizes real-world implementation, maintainable code structure, and scalable architecture.

---

## Prerequisites
Before running the project, ensure the following are installed:

- **Java 21** (or a compatible version)
- **Apache Maven**
- **Git** (optional, for cloning the repository)

---

## Setup Instructions

### 1. Obtain the Project
You can obtain the repository either by cloning or downloading as a ZIP:

```bash
git clone https://github.com/your-username/mega-project.git
```

Or download the ZIP from the repository page and extract it to a directory of your choice.

### 2. Navigate to the Project Directory
```bash
cd mega-project
```

### 3. Build the Project

Execute Maven to resolve dependencies and compile the project:

```bash
mvn clean install
```

### 4. Run the Application

Launch the Spring Boot server:
```bash
mvn spring-boot:run
```

The application will start (by default) on:
```arduino
http://localhost:8080
```
## Project Structure

| File / Directory                   | Description                           |
|-----------------------------------|---------------------------------------|
| `MegaProgettoApplication.java`     |  Entry point of the application     |
| `controller/`                      |  REST controllers for HTTP requests |
| `service/`                         |  Business logic layer               |
| `model/`                           |  Data entities and domain models    |



## Layers Overview

### Controller Layer 
- Handles HTTP requests and routing.
- Maps endpoints to corresponding service methods.

### Service Layer 
- Contains business logic and processing.
- Ensures separation of concerns from controllers and models.

### Model Layer 
- Defines application data structures.
- Represents entities and domain objects.

---

## Notes ⚠️
- Ensure the `JAVA_HOME` environment variable points to **Java 21**.
- Do not modify the directory structure; it is pre-configured for Maven and Spring Boot.
- Maven automatically manages all dependencies.

