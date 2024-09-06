# Library-API

## Overview

This is a simple **Library API** built with **Java Spring Boot**. It allows you to manage books, clients, and authors, with automatic relations created between them. You can add, remove, modify, filter, and retrieve information about books, clients, and authors in the database.

## Features

- **Add, Remove, Update**: Manage books, clients, and authors.
- **Relations**: The API automatically creates relationships between books, clients, and authors.
- **Filter and Retrieve**: Search for books, clients, or authors by various criteria.

## Technologies Used

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## Database Setup

1. **Install PostgreSQL** and create a new database:

   ```sql
   CREATE DATABASE library_api;
   ```

2. **Create a user** and grant privileges:

   ```sql
   CREATE USER library_user WITH PASSWORD 'password';
   GRANT ALL PRIVILEGES ON DATABASE library_api TO library_user;
   ```

3. Update the database connection in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/library_api
   spring.datasource.username=library_user
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   ```

## Installation and Running

1. **Clone the repository**:

   ```bash
   https://github.com/MF853/Library-API.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd library-api
   ```

3. **Build the project**:

   ```bash
   mvn clean install
   ```

4. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

   The API will be accessible at `http://localhost:8080`.
