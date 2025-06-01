# Automotive System
The **Automotive System** is a Java-based project that simulates the functionality of a connected car system. It integrates various components such as vehicle diagnostics, infotainment, telematics, and database management to provide a comprehensive connected car experience. The application is designed to demonstrate real-world automotive system features in a simulated environment.

![Automotive Project GIF](https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExY241M3FtN2wzN2ZyOGkwcjhodG9oemJmMWZiNWx3NDhtNHJteHN1NCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/0SHsf58wgiFcTTKkzZ/giphy.gif)

### Java Concepts Used

This project leverages the following Java concepts:

- **Object-Oriented Programming (OOP)**: Classes like [`ConnectedCarApp`], [`VehicleDiagnostics`], and [`TelematicsSystem`]demonstrate encapsulation, inheritance, and polymorphism.
- **File I/O**: Reads and writes data from files such as `dtc_codes.txt`, `engine_temp.txt`, and others in the `IO` directory.
- **Multithreading**: Simulates concurrent operations in components like [`ConnectedCarServer`].
- **Database Integration**: Uses SQL scripts (e.g., `vehiculeDataBase.sql`) to manage vehicle data.
- **Exception Handling**: Handles runtime errors gracefully, ensuring system stability.
- **Collections Framework**: Utilizes data structures like `ArrayList` and `HashMap` for efficient data management.
- **Interfaces and Abstraction**: Implements modular design with abstract classes and interfaces.
- **Networking**: Simulates server-client communication in the connected car ecosystem.

---

## Requirements

To run this project, ensure you have the following:

- **Java Development Kit (JDK)**: Version 8 or higher.
- **SQL Database System**: For managing vehicle data.
- **Text Editor or IDE**: Such as Visual Studio Code, IntelliJ IDEA, or Eclipse.
- **Command Line Interface**: For compiling and running the application.

---

## Installation and Setup

Follow these steps to set up and run the project:

1. **Clone the Repository**:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Set Up the Database**:
   - Import the SQL script `vehiculeDataBase.sql` into your database system.
   - Configure the database connection in `VehicleDataBase.java` if required.

3. **Compile the Project**:
   ```sh
   javac *.java IO/*.java
   ```

4. **Run the Application**:
   ```sh
   java Main
   ```

5. **Verify the Output**:
   - Check the console for application logs.
   - Review generated files in the `IO` directory for diagnostics and system data.