# Portfolio Backend

A robust **Spring Boot REST API** for managing personal portfolio data. This backend service provides comprehensive endpoints for portfolio management, authentication, resume handling, contact requests, and more.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Docker Deployment](#docker-deployment)
- [Database Schema](#database-schema)
- [Services](#services)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

**Portfolio Backend** is a Spring Boot application designed to serve as the backbone for a personal portfolio website. It manages all portfolio-related data including:

- User authentication and password management
- Skills, education, experience, and projects
- Resume uploads and downloads
- Professional certificates
- Profile information
- Contact requests and inquiries

The application is fully containerized with Docker for easy deployment.

---

## ✨ Features

### Core Features
- 🔐 **User Authentication** - Login with email and password verification
- 📝 **Portfolio Management** - Create, update, and manage portfolio sections
- 💼 **Career Data** - Store and manage skills, education, experience, and projects
- 📄 **Resume Management** - Upload and download resume files
- 🎓 **Certificates** - Upload and manage professional certificates
- 👤 **Profile Management** - Manage profile picture and personal data

### Contact & Communication
- 📧 **Email Integration** - Send emails for various contact requests
- 💬 **General Messages** - Receive and manage general messages
- 💼 **Job Offers** - Receive and process job offer inquiries
- 🤝 **Collaboration Requests** - Manage collaboration opportunities
- 📅 **Meeting Requests** - Schedule and track meeting requests
- 🚀 **Startup Inquiries** - Receive startup idea pitches
- 📋 **Document Requests** - Handle document request submissions
- 🎯 **Project Requests** - Manage incoming project requests

### Technical Features
- ✅ **CORS Support** - Cross-origin resource sharing enabled
- 📁 **File Upload/Download** - Secure file handling
- 🗄️ **PostgreSQL Integration** - Reliable data persistence
- 🔄 **JPA/Hibernate** - Object-relational mapping
- 🐳 **Docker Ready** - Multi-stage Docker build included
- 🏗️ **Layered Architecture** - Clean separation of concerns

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Framework** | Spring Boot 4.0.0 |
| **Language** | Java 17 |
| **Database** | PostgreSQL |
| **ORM** | Spring Data JPA / Hibernate |
| **Build Tool** | Maven 3.8.5 |
| **Container** | Docker |
| **Server** | Embedded Tomcat (Port 8080) |

---

## 📦 Prerequisites

Before running this application, ensure you have:

- **Java 17** or higher installed
- **Maven 3.6+** installed
- **PostgreSQL 12+** database server running
- **Docker** (optional, for containerized deployment)
- **Git** for version control

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/slshree1/Portfolio_backend.git
cd Portfolio_backend
```

### 2. Build the Project

```bash
mvn clean package
```

### 3. Run the Application

#### Option A: Using Maven
```bash
mvn spring-boot:run
```

#### Option B: Using JAR
```bash
java -jar target/PortfolioBackend-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

---

## ⚙️ Configuration

### Database Configuration

Edit `src/main/resources/application.properties`:

```properties
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://your-host:5432/your-database?sslmode=require
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Email Configuration

Configure Gmail SMTP for sending emails:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> **Note:** For Gmail, use an [App Password](https://myaccount.google.com/apppasswords) instead of your regular password.

---

## 📁 Project Structure

```
Portfolio_backend/
├── src/
│   ├── main/
│   │   ├── java/in/sli/main/
│   │   │   ├── PortfolioBackendApplication.java      # Main entry point
│   │   │   ├── beans/                                 # Entity classes
│   │   │   │   ├── Certificate.java
│   │   │   │   ├── Education.java
│   │   │   │   ├── Experience.java
│   │   │   │   ├── LoginRequest.java
│   │   │   │   ├── LoginResponse.java
│   │   │   │   ├── ProfileData.java
│   │   │   │   ├── Project.java
│   │   │   │   ├── ResumeData.java
│   │   │   │   ├── Skill.java
│   │   │   │   └── contact/
│   │   │   ├── controllers/                           # REST Controllers
│   │   │   │   ├── MyController.java
│   │   │   │   ├── ContactController.java
│   │   │   │   ├── DataRequestController.java
│   │   │   │   └── DataDeleteController.java
│   │   │   ├── services/                              # Business logic
│   │   │   │   ├── CertificateService[Impl].java
│   │   │   │   ├── EducationService[Impl].java
│   │   │   │   ├── ExperienceService[Impl].java
│   │   │   │   ├── ProjectService[Impl].java
│   │   │   │   ├── SkillService[Impl].java
│   │   │   │   ├── ProfileDataService[Impl].java
│   │   │   │   ├── ResumeDataService[Impl].java
│   │   │   │   ├── LoginServices[Impl].java
│   │   │   │   └── EmailService.java
│   │   │   └── repository/                            # Data access layer
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── uploads/                                           # File storage directory
├── pom.xml                                            # Maven configuration
├── Dockerfile                                         # Docker image definition
├── mvnw / mvnw.cmd                                   # Maven wrapper scripts
└── README.md                                          # This file
```

---

## 🔌 API Endpoints

### Authentication Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/login` | User login |
| POST | `/updatePassword` | Update user password |
| GET | `/forgotPassword` | Send forgot password email |

### Portfolio Data Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/saveSkill` | Add a new skill |
| POST | `/saveExperience` | Add work experience (with files) |
| POST | `/saveProject` | Add a project |
| POST | `/saveEducation` | Add education record (with files) |
| POST | `/saveCertificate` | Add certificate (with file) |
| POST | `/updateResume` | Upload/update resume |
| POST | `/updateProfileData` | Update profile data and picture |

### Contact & Communication Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/sendGeneralMessage` | Send general message |
| POST | `/sendJobOfferMessage` | Submit job offer |
| POST | `/sendProjectRequest` | Submit project request |
| POST | `/sendColabRequest` | Send collaboration request |
| POST | `/request-meeting` | Request a meeting |
| POST | `/startup-idea` | Submit startup idea |
| POST | `/sendDocRequest` | Request documents |
| GET | `/downloadResume` | Download latest resume |

### Data Retrieval Endpoints

*(Implemented in DataRequestController)*
- Retrieve portfolio data (skills, education, experience, projects, certificates)
- Fetch profile information
- Get resume details

### Data Deletion Endpoints

*(Implemented in DataDeleteController)*
- Delete portfolio items by ID
- Manage data lifecycle

---

## 🐳 Docker Deployment

### Build Docker Image

```bash
docker build -t portfolio-backend:latest .
```

### Run Docker Container

```bash
docker run -d \
  --name portfolio-backend \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host:5432/db \
  -e SPRING_DATASOURCE_USERNAME=user \
  -e SPRING_DATASOURCE_PASSWORD=password \
  portfolio-backend:latest
```

### Docker Compose (Optional)

Create a `docker-compose.yml` for complete stack:

```yaml
version: '3.8'
services:
  backend:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/portfolio_db
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: password
    depends_on:
      - postgres
  
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: portfolio_db
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
```

Run with: `docker-compose up -d`

---

## 🗄️ Database Schema

### Key Tables

| Entity | Purpose |
|--------|---------|
| **LoginRequest** | User credentials |
| **Skill** | Professional skills |
| **Experience** | Work experience records |
| **Education** | Educational background |
| **Project** | Portfolio projects |
| **Certificate** | Professional certificates |
| **ProfileData** | User profile information |
| **ResumeData** | Resume file storage |

All entities use JPA annotations for ORM mapping and automatically create/update tables via Hibernate.

---

## 🔧 Services

### CertificateService
- Add, retrieve, and manage certificates
- Handle certificate file uploads

### EducationService
- Manage education records
- Handle institution logos and certificates

### ExperienceService
- Store and retrieve work experience
- Manage company logos and documents

### ProjectService
- Create and manage portfolio projects
- Store project details and metadata

### SkillService
- Add and manage professional skills
- Link skills to projects

### ProfileDataService
- Manage profile information
- Handle profile picture uploads

### ResumeDataService
- Handle resume file uploads and downloads
- Track resume versions

### EmailService
- Send emails for contact requests
- Configure SMTP settings

### LoginServices
- Authenticate users
- Manage user credentials
- Handle password updates

---

## 🔐 Security Considerations

- ✅ CORS enabled for frontend integration
- ⚠️ **TODO:** Implement JWT authentication for enhanced security
- ⚠️ **TODO:** Add input validation and sanitization
- ⚠️ **TODO:** Implement role-based access control (RBAC)
- ⚠️ **TODO:** Use environment variables for sensitive data
- ⚠️ **TODO:** Add HTTPS/SSL configuration

---

## 📝 File Upload

Files are stored in the `uploads/` directory:

```
uploads/
├── documents/        # Resumes, certificates
├── images/          # Profile pictures, logos
└── files/           # Other documents
```

Ensure this directory has proper read/write permissions.

---

## 🧪 Testing

Run tests with Maven:

```bash
mvn test
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 🐛 Known Issues & Future Enhancements

### Known Issues
- Password hardcoded in some controllers (needs refactoring)
- No JWT token-based authentication
- Limited input validation

### Future Enhancements
- [ ] Implement JWT authentication
- [ ] Add Swagger/OpenAPI documentation
- [ ] Implement logging with SLF4J
- [ ] Add comprehensive error handling
- [ ] Unit and integration tests
- [ ] API rate limiting
- [ ] Caching with Redis
- [ ] Enhanced security features

---

## 📄 License

This project is open source and available under the MIT License.

---

## 👨‍💻 Author

**Shreyas Limbikai**
- GitHub: [@slshree1](https://github.com/slshree1)
- Email: slshree321@gmail.com

---

## 📞 Support

For issues, questions, or suggestions, please open an [issue](https://github.com/slshree1/Portfolio_backend/issues) on GitHub.

---

## 🔗 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Docker Documentation](https://docs.docker.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

---

**Last Updated:** May 7, 2026
