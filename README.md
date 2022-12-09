# Selenium-TestNG-Automation

Technology:

Tool: Selenium Webdriver
IDE: Intellij IDEA
Build tool: Gradle
Language: Java
Testing Framework : TestNG

Prerequisite:

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

