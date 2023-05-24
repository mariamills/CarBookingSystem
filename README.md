
# Car Booking CLI Project

This is a command-line interface (CLI) Car Booking project implemented in Java, following an N-Tier architecture. It allows users to book car rentals. The project structure includes the following components:

- `org.mariamills.booking`: Contains the CarBookingDao and CarBookingService classes responsible for car booking functionality.
- `org.mariamills.car`: Includes the CarDao and CarService classes for managing car information.
- `org.mariamills.user`: Consists of the User and UserService classes for user management.
- `Main.java`: The entry point of the project that sets up the necessary services and provides the CLI interface for interacting with the system.

## Functionality
The Car Booking CLI project provides the following functionalities:

- **Book a Car**: Users can book a car by selecting a car registration number and providing the user ID. The booking is associated with a unique booking ID.
- **View All User Booked Cars**: Users can view all cars that have been booked by users.
- **View All Bookings**: Users can view all existing bookings, including the booking ID, car details, and user information.
- **View All Available Cars**: Users can view all cars that are currently available for booking. 
- **View All Electric Cars**: Users can view all available electric cars. 
- **View All Users**: Users can view a list of all users registered in the system. 
- **Cancel a Booking**: Users can cancel a booking by providing the booking ID. 
- **Exit**: Users can choose to exit the application. This terminates the program and ends the car booking session.

## Running the Application

To run the Car Booking CLI project, follow these steps:

1. Make sure you have Java Development Kit (JDK) installed on your machine.
2. Open a terminal or command prompt and navigate to the project's root directory.
3. Compile the source code using the following command:

```bash
javac Main.java
```
4. Execute the compiled Main class using the following command:
```bash
java Main
```
5. The CLI interface will be displayed, allowing you to interact with the car booking system. Follow the provided menu options to perform various actions, such as booking a car, viewing bookings, and canceling bookings.

## Dependencies

This project utilizes Maven as the build and dependency management tool. The project's dependencies are defined in the pom.xml file. The following dependencies are included:

- JavaFaker: A Java library for generating fake data. It is used for testing and generating fake user data.
- JUnit Jupiter: A testing framework for Java. It is used for unit testing the project components.
To build the project and resolve the dependencies using Maven, run the following command from the project's root directory:
```bash
mvn clean install
```

## Learnings / Familiarity
During the development of this Car Booking CLI project, several key learnings and areas of increased familiarity were gained:

- N-Tier Architecture: Implemented the project following an N-Tier architecture, separating concerns into distinct layers such as data access, business logic, and presentation.
- Command-Line Interface (CLI) Development: Gained experience in building a CLI application that interacts with users through a text-based interface.
- Java Faker Library: Utilized the Java Faker library for generating fake data, enabling testing scenarios with realistic user information.
- JUnit Testing: Employed JUnit Jupiter for unit testing the project components, ensuring the correctness of functionality and identifying potential issues.
- Maven: Utilized Maven as the build and dependency management tool, simplifying the project setup and managing dependencies.
These learnings and increased familiarity contribute to a better understanding of software architecture, user interaction, and testing practices in Java projects.

## Credits

This project was developed in collaboration with [amigoscode.com](https://amigoscode.com/), as part of the [Master Java course](https://amigoscode.com/p/java-master-class). The course covers Java basics and advanced topics, providing a comprehensive learning experience.

Feel free to explore and modify the project to suit your needs.

Enjoy booking cars with the Car Booking CLI project!


