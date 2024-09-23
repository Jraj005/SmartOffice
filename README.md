Smart Office Facility Management System
This is a console-based application that manages conference room bookings, detects room occupancy, and automates control of lights and air conditioning in a smart office environment. The application adheres to best coding practices and demonstrates key design patterns such as Singleton, Observer, and Command.

Features
Room Booking: Book and cancel conference rooms for a specific time and duration.
Occupancy Detection: Detects room occupancy and automatically controls lights and air conditioning based on occupancy.
Automatic Room Release: Automatically releases room bookings if unoccupied for more than 5 minutes.
Design Patterns Used
Singleton Pattern: Ensures that there is only one instance of the office configuration.
Observer Pattern: Monitors changes in room occupancy and triggers actions (lights, AC).
Command Pattern: Encapsulates room booking and cancellation as commands to allow for easy extension and modification.
Project Structure
bash
Copy code
/src
  ├── Main.java                 # Entry point of the application
  ├── OfficeConfig.java          # Singleton for managing global office configuration
  ├── Room.java                  # Room class for managing bookings and occupancy
  ├── RoomSensor.java            # Sensor class, observer of room occupancy
  ├── BookRoomCommand.java       # Command class for booking rooms
  ├── CancelBookingCommand.java  # Command class for canceling bookings
  ├── Command.java               # Interface for command operations
  └── OccupancyObserver.java     # Observer interface for monitoring room occupancy
Getting Started
Prerequisites
Java 8 or higher installed.
Steps to Run Locally
Clone the repository:

bash
Copy code
git clone https://github.com/YOUR-USERNAME/SmartOfficeFacility.git
Navigate to the project directory:

bash
Copy code
cd SmartOfficeFacility/src
Compile the Java files:

bash
Copy code
javac *.java
Run the program:

bash
Copy code
java Main
Usage Examples
Positive Cases
Configure Rooms:

Input: Config room count 3
Output: Office configured with 3 rooms.
Book Room 1:

Input: Block room 1 09:00 60
Output: Room 1 booked from 09:00 for 60 minutes.
Occupancy in Room 1:

Input: Add occupant 1 2
Output:
Room 1 is now occupied by 2 persons.
AC and lights turned on.
Release Room 1:

Input: Add occupant 1 0
Output:
Room 1 is now unoccupied.
AC and lights turned off.
Error Handling
Invalid Room Number: If a room ID is not valid, the system returns an error.
Time Format Validation: The system checks that time inputs are in HH:mm format.
Booking Conflicts: The system prevents double bookings for the same room at the same time.
Technologies Used
Java: Core programming language.
Java Util Logging: Used for logging events such as turning on lights and air conditioning.
