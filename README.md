# Cloud Vendor API

## Overview
The Cloud Vendor API is a RESTful API designed to manage cloud vendor information with Create, Read, Update, and Delete (CRUD) functionalities. It provides endpoints for interacting with cloud vendor data using HTTP methods. This project emphasizes best practices in API development, including unit testing, exception handling, custom JSON response handling, and comprehensive documentation.

![image](https://github.com/Swapnaroop2001/CloudVendorProject/blob/main/CloudVendorAPI.png)

## Features
- **CRUD Operations:** Implement Create, Read, Update, and Delete operations for managing cloud vendor information.
- **Unit Testing:** Utilize JUnit, Mockito, and AssertJ for comprehensive unit testing to ensure the reliability and correctness of the codebase.
- **Database Integration:** Use H2 database for testing purposes and MySQL for production database connection, ensuring data persistence and integrity.
- **Layered Architecture:** Follow a clear separation of concerns with Controller, Service, and Repository layers.
- **Exception Handling:** Implement robust exception handling mechanisms to gracefully manage errors and provide meaningful feedback to clients.
- **Custom JSON Response Handling:** Customize JSON responses to meet specific requirements and enhance user experience.
- **Documentation:** Utilize Swagger to automatically generate comprehensive API documentation, facilitating ease of use and understanding for developers.

![image](https://github.com/Swapnaroop2001/CloudVendorProject/blob/main/CloudVendorAPIExpanded.png)
## Layers Overview
- **Controller Layer:** Handles incoming HTTP requests, delegates tasks to the service layer, and returns appropriate responses to clients.
- **Service Layer:** Contains business logic and performs operations requested by the controller layer. It acts as an intermediary between the controller and repository layers.
- **Repository Layer:** Manages data access and storage, interacting with the database to perform CRUD operations.

## Endpoints
- `GET /api/vendors`: Retrieve all cloud vendors.
- `GET /api/vendors/{id}`: Retrieve details of a specific cloud vendor.
- `POST /api/vendors`: Create a new cloud vendor.
- `PUT /api/vendors`: Update details of a specific cloud vendor.
- `DELETE /api/vendors/{id}`: Delete a cloud vendor.

## Technologies Used
- **Spring Boot:** Facilitates rapid development of robust, production-ready APIs.
- **JUnit, Mockito, AssertJ:** Frameworks for unit testing to ensure code quality and reliability.
- **H2 Database:** In-memory database for testing purposes.
- **MySQL:** Production database for storing cloud vendor information.
- **Swagger:** Automatically generates API documentation, making it easy for developers to understand and consume the API.

## Getting Started
1. Clone the repository.
2. Configure the database connection properties in `application.properties`.
3. Run the application.
4. Access the API endpoints using an HTTP client or Swagger UI.

## Contributors
- Swapnaroop Salgare

## License
This project is licensed under the MIT License.
