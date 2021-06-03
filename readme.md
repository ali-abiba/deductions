## Deduction API
This API allows users to create employers and add employees to view their benefits deduction payment.

### Restaurant API Application

###### Dependencies
 - Gradle version 6.8.3+
 - Java 15.0.1+
 
###### Build
First you must build the schema and configure the application.properties file to match your database isntance.

To build the application, navigate to the source folder in your terminal and run the command: `gradle build`

###### Running
To run the application, first make sure the application has been built. Then run the command: `gradlew bootrun`

###### Testing
The unit tests run automatically with each build, however to run the unit tests individually, run the command: `gradle test`