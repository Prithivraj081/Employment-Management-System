# Employment-Management-System
Employment Agreement Management System A Spring Boot project designed to manage employment agreements using RESTful APIs.

Features CRUD operations for employment agreements. Partial updates to employment agreements. Integration with a database (e.g., MySQL, PostgreSQL). Easy deployment using Spring Boot. Prerequisites Make sure you have the following installed on your system:

Java Development Kit (JDK) 17 or later Download JDK

Apache Maven (for building the project) Install Maven

Database

MySQL (preferred) or any other supported database. Postman or cURL (optional for API testing).

Eclipse IDE (recommended for development).

Setup Instructions

Clone the Repository
git clone https://github.com/your-username/employment-agreement-management.git cd employment-agreement-management 2. Configure the Database Install MySQL and create a database: sql Copy code CREATE DATABASE employment_agreements; Open the src/main/resources/application.properties file, and configure your database connection:

Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/employment_agreements spring.datasource.username=your_username spring.datasource.password=your_password

Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect 3. Configure Environment Variables If sensitive information (e.g., passwords) is managed via environment variables, set them up as follows:

export DB_USERNAME=your_username export DB_PASSWORD=your_password Update application.properties to use these:

properties Copy code spring.datasource.username=${DB_USERNAME} spring.datasource.password=${DB_PASSWORD} 4. Build the Project Run the following command in the project root directory to build the project:

mvn clean install 5. Run the Application Start the Spring Boot application:

mvn spring-boot:run 6. Access the APIs Once the application is running, the APIs will be accessible at:

Base URL: http://localhost:8080/api/employment-agreements Example Endpoints: Get All Agreements GET /api/employment-agreements

Get Agreement by ID GET /api/employment-agreements/{id}

Create a New Agreement POST /api/employment-agreements Payload:

{ "employeeName": "John Doe", "position": "Software Engineer", "salary": 75000.0, "startDate": "2024-01-01", "endDate": "2025-01-01" } Update Agreement PUT /api/employment-agreements/{id}

Delete Agreement DELETE /api/employment-agreements/{id}

Database Initialization If you want to pre-load data into the database, add it to data.sql in the src/main/resources folder:

INSERT INTO employment_agreement (employee_name, position, salary, start_date, end_date) VALUES ('Jane Smith', 'Product Manager', 90000.0, '2024-01-01', '2025-01-01'); Testing the APIs Postman: Import the API endpoints into Postman to test them. cURL: Use the command line to test, e.g.,

curl -X GET http://localhost:8080/api/employment-agreements Troubleshooting Database Connection Issues: Verify that the database service is running and the credentials in application.properties are correct.

Port Conflicts: If port 8080 is already in use, change it in application.properties:

properties Copy code server.port=8081 NullPointerException: Ensure all fields in the request payload are correctly populated and handle null values in the service layer.

Author Prithiv Raj Feel free to reach out at prithivrajr7@gmail.com for any questions or suggestions.
