# Web - Framework Setup

Please insatll eclipse for Java Developers

## Cucumber plugin Installation

Please install cucumber plugin to run the tests.

In the Menu, 

- please click on Help -> Eclipse Marketplace
- Search for cucumber and install Cucumber Eclipse Plugin

**Once Installation is done, please restart Eclipse**

## Running the Tests

1. Lauch Eclipse
2. Build the Maven project, Right click on project -> Maven -> Update Project
3. Open TestRunner.java in src/test/java/com/relex/testRunner
4. Right click and Run As JUnit Test

## Web - Framework Overview

The framework is Cucumber(BDD) with Selenium using Page Object Model Design Pattern.

#The Main folder has below packages and classes

##Factory Package - DriverFactory Class
  This Class has the methods to initialise WebDriver based on the given browser details
  
##Utils Package
  1.This package has a ConfigReader class to read the details from config properties file which has browser details
  2.The GlobaDataVariables class has getters and setters to store the prices of items added to cart, so that the price details can be verified through out checkout
  
##Pages and Components package
  Pages package contains classes for each page, where we declare elements and methods to perform any functionalities in particular page.
  Components package contains classes for common resubale components present throughout the web page. For Ex, Header is a common component present in all the pages
  
#The Test folder has below packages

#Hooks package
  Hooks class is used to launch the browser, quit the browser and a method to take screenshot if a test scenario is failed and attached to cucumber report
 
#TestRunner pacakge
  TestRunner class is used to bind the Feature file with Step Defintions 
 
#StepDefinitions package
  This package has steps classes for each page, where the steps written in Feature file are genarated here
 
Test Resources folder has the Feature files


