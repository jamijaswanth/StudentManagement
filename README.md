# Student Management Microservice

Spring Boot + Maven project for Question 10. It exposes a REST endpoint that returns student IDs and names as JSON.

## Requirements
- JDK 17 or later
- Spring Tool Suite (STS) / Eclipse
- Maven (STS can use its embedded Maven)

## Project structure

```text
StudentManagement
├── pom.xml
└── src
    ├── main
    │   ├── java/com/example/studentmanagement
    │   │   ├── StudentManagementApplication.java
    │   │   ├── controller/StudentController.java
    │   │   └── model/Student.java
    │   └── resources/application.properties
    └── test
        └── java/com/example/studentmanagement/controller
            └── StudentControllerTest.java
```

## Import into STS
1. Extract the ZIP file.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted `StudentManagement` folder.
5. Select the project and click **Finish**.
6. If dependencies do not load, right-click the project → **Maven → Update Project**.

## Run the application
1. Open `StudentManagementApplication.java`.
2. Right-click → **Run As → Spring Boot App**.
3. Open this URL in a browser:

   `http://localhost:8080/students`

Expected JSON:

```json
[
  {"studentId":101,"studentName":"Jaswanth"},
  {"studentId":102,"studentName":"Rahul"},
  {"studentId":103,"studentName":"Priya"}
]
```

## Run Unit Tests in STS
1. Right-click the project → **Run As → JUnit Test**.
2. Alternatively, right-click `StudentControllerTest.java` → **Run As → JUnit Test**.
3. A green JUnit bar indicates the test passed.

The test uses `@WebMvcTest(StudentController.class)` to load only the web/controller layer and `MockMvc` to simulate `GET /students` without starting a real web server. It checks HTTP 200, JSON content type, the number of records, and each student's ID and name.

## Run tests using Maven
```bash
mvn test
```

## Build executable JAR
```bash
mvn clean package
```

The JAR is created under `target/`.

## Deploy on Render
Push this project to GitHub and create a Render Web Service connected to the repository.

- Build command: `mvn clean package`
- Start command: `java -jar target/StudentManagement-0.0.1-SNAPSHOT.jar`

The application reads Render's `PORT` environment variable and defaults to port 8080 locally. After deployment, test:

`https://YOUR-RENDER-URL/students`

## Notes
- This is a simple demonstration with in-memory, hard-coded student records; it does not use a database.
- The unit test is a controller web-slice test, not a full application-context test.
