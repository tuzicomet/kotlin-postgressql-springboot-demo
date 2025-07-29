# Kotlin PostgreSQL Spring Boot Demo

This is a simple demo project showing a basic Kotlin backend using Spring Boot connected to a PostgreSQL database via Docker. This app was created solely for my own learning purposes.

---

## What this demo includes

- Kotlin backend using Spring Boot
- PostgreSQL database running in Docker
- Docker Compose setup to run both app and database easily
- Basic CRUD operations (getting, adding, updating, and deleting users)

All API endpoints have been successfully tested using Postman to verify functionality and correct responses.

---

## How to run

1. Open your terminal.  

2. Navigate to the project folder:

```bash
cd path/to/kotlin-postgresql-springboot-demo
```

3. Start the PostgreSQL database container:

```bash
docker compose up -d db
```

4. Build the Kotlin app container:

```bash
docker compose build
```

5. Start the Kotlin app container:

```bash
3. docker compose up kotlinapp
```

## Requirements

- **Docker & Docker Compose** installed on your machine  
  (for running the database and the app containers)

- A Unix-like shell or terminal (e.g., Git Bash on Windows, Terminal on macOS/Linux)

## Important notes about credentials
The PostgreSQL credentials (database name, username, password) are currently hardcoded in the docker-compose.yml file for simplicity and quick testing.

This is NOT secure and should never be done in production or public repos.

For real projects, environment variables should be loaded from a gitignored .env file.