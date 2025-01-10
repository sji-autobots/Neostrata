Selenium POM Project
Introduction
This project uses the Page Object Model (POM) design pattern to create a test automation framework using Selenium WebDriver. The purpose of the framework is to provide a scalable and maintainable solution for automating web application testing.

Prerequisites
Java 8 or higher
Maven
Selenium WebDriver
TestNG

Framework Structure
The project is structured as follows:

src/main/java - Contains the Page Object classes for each page of the web application under test and other configuration files.
src/test/java - Contains the test cases and test suites.
pom.xml - Contains the dependencies and build configuration for the project.
testng.xml - Contains the different test suites.

Reporting
TestNG reports will be generated after the tests have been executed. The reports can be found in the 'target/surefire-reports' directory. Also, extend report will be generated in 'ExtentReport' directory.

Conclusion
This Selenium POM project provides a solid foundation for automating web application testing and can be easily extended to support more complex testing scenarios.