# Selenium-TestNG-Automation

This is a complete project where an comprehensive human capital management site is automated by writing test suites using selenium-webdriver and TestNg as testing framework.

The following key modules/pages are automated:

Login

AddEmployeePage

ViewEmployeePage

DashboardPage

Key test cases are written for each module and test suites created including the positive and negative test cases.
A state-transition flow of test-cases are designed and run like a user buying a product from an e-commerce site.
For failed test cases it will take a screenshot aswell at the point of failure.
The test runner codes can be extracted from this link.
The module test case steps code can be extracted from this link.


##Technology:

Tool: Selenium Webdriver

IDE: Intellij IDEA

Build tool: Gradle

Language: Java

Testing Framework : TestNG

##Prerequisite:

Need to install jdk 11, gradle and allure
Configure Environment variable for jdk 11, gradle and allure
Clone this project and unzip it
Open the project folder
Double click on "build.gradle" and open it through IntellIJ IDEA
Let the project build successfully
Click on "Terminal" and run the automation scripts

Run the Automation Script by the following command:

gradle clean test 

Selenium will open the browser and start automating.
After automation to view allure report , give the following commands:

allure generate allure-results --clean -o allure-report

allure serve allure-results

