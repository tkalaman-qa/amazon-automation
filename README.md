# Amazon UI Automation Framework

This is a simple test automation framework built to demonstrate my understanding of BDD using Java, Selenium WebDriver, TestNG, and Cucumber.

It's based on similar frameworks I’ve worked with in previous client projects, and I created this version to use as a public example for job interviews and portfolio purposes.

## Technologies used

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- ExtentReports
- Page Object Model

## Scenario

The test scenario automates the process of searching for a product on Amazon and adding it to the cart. Here's a summary of the steps:

- Open the Amazon homepage
- Accept cookies
- Search for a product
- Apply filters (Shipped by Amazon, Brand: Apple)
- Select the first product from results
- Add it to the cart
- Check the shopping cart

This scenario is written using Gherkin language inside a `.feature` file.

## Project structure

- `DriverFactory.java`: Initializes and manages WebDriver
- `Hooks.java`: Sets up and tears down the test environment
- `ConfigReader.java`: Loads configuration properties
- `Pages/`: Contains page object classes
- `StepDefinitions/`: Contains the step definitions linked to the feature file
- `Features/`: Stores the `.feature` file written in Gherkin
- `ExtentReport.html`: Automatically generated after each test run

