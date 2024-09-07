# Hospital Appointment Backend API
This repository contains the backend API for a hospital appointment booking application, built using Spring Boot, Java, and SQL. The API allows users to book appointments by selecting a hospital, department, doctor, and available date and time.

Prerequisites
Java Development Kit (JDK): Ensure you have a compatible JDK installed.
Maven or Gradle: A build automation tool for managing dependencies and building the project.
Database: A relational database like MySQL, PostgreSQL, or H2 (for testing).
Setup

Clone the Repository:
Bash
git clone https://github.com/your-username/hospital-appointment-backend.git

Database Configuration:
Create a database with the specified name and credentials in your database management system.
Update the database connection details in the application.properties file.

Build the Project:
Use Maven or Gradle to build the project. For example, with Maven:
Bash
mvn clean install

Run the Application:
Start the Spring Boot application using Maven or Gradle. For example, with Maven:
Bash
mvn spring-boot:run

API Endpoints

Example:

Get all hospitals:
GET /hospitals
Get departments by hospital ID:
GET /hospitals/{hospitalId}/departments
Get doctors by department ID:
GET /departments/{departmentId}/doctors
Get available appointment slots:
GET /doctors/{doctorId}/appointments/available
Book an appointment:
POST /appointments
Data Structure
![hospitallApp](https://github.com/PabloProgramming/hospitalApp/assets/169392720/8cf836ea-8ab8-4f36-a479-b67f83f4ac64)

Testing
Unit Tests
Spring Boot Test: Utilize Spring Boot's testing framework to create unit tests for individual components, such as services, repositories, and controllers.
Mockito: Use Mockito to mock dependencies and isolate the component being tested.
JUnit: Employ JUnit for writing assertions and test cases.
Example:

Java
@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private   
 AppointmentService appointmentService;

    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    public void shouldBookAppointment() throws Exception {
        // Create a mock doctor and appointment
        Doctor doctor = new Doctor();
        Appointment appointment = new Appointment();

        // Mock behavior of doctorRepository
        when(doctorRepository.findById(any())).thenReturn(Optional.of(doctor));

        // Mock behavior of appointmentService
        when(appointmentService.bookAppointment(any())).thenReturn(appointment);

        // Perform the request
        mockMvc.perform(post("/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointment)))
                .andExpect(status().isCreated());   

    }
}

Integration Tests
Spring Boot Test: Leverage Spring Boot Test to test the interaction between multiple components.
In-memory database: Use an in-memory database like H2 for integration tests to avoid affecting production data.
Example:

Java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetAvailableAppointments() {
        // Create a sample doctor and appointment
        Doctor doctor = new Doctor();
        Appointment appointment = new Appointment();

        // Save the doctor and appointment to the database
        doctorRepository.save(doctor);
        appointmentRepository.save(appointment);

        // Make the request
        ResponseEntity<List<Appointment>> response = restTemplate.getForEntity("/doctors/{doctorId}/appointments/available", List.class, doctor.getId());

        // Assert the response
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(1);
    }
}

Exception Handling
@ControllerAdvice: Use @ControllerAdvice to create a global exception handler to handle common exceptions.
@ExceptionHandler: Annotate methods with @ExceptionHandler to specify the exception type they handle.
ResponseEntity: Return a ResponseEntity with a custom error message and HTTP status code.
Example:

Java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAppointmentNotFoundException(AppointmentNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}

Additional Notes
Error Handling: 
The API should handle errors gracefully and return appropriate error responses.
Security: Implement security measures to protect sensitive data, such as using authentication and authorization mechanisms.
Scalability: Consider scalability factors for handling increased load, such as using caching or distributed systems.
