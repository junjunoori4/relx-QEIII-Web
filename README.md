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

**The Main folder has below packages and classes**

**Factory Package - DriverFactory Class**
  This Class has the methods to initialise WebDriver based on the given browser details
  
**Utils Package**
  1.This package has a ConfigReader class to read the details from config properties file which has browser details
  2.The GlobaDataVariables class has getters and setters to store the prices of items added to cart, so that the price details can be verified through out checkout
  
**Pages and Components package**
  Pages package contains classes for each page, where we declare elements and methods to perform any functionalities in particular page.
  Components package contains classes for common resubale components present throughout the web page. For Ex, Header is a common component present in all the pages
  
**The Test folder has below packages**

**Hooks package**
  Hooks class is used to launch the browser, quit the browser and a method to take screenshot if a test scenario is failed and attached to cucumber report
 
**TestRunner pacakge**
  TestRunner class is used to bind the Feature file with Step Defintions 
 
**StepDefinitions package**
  This package has steps classes for each page, where the steps written in Feature file are genarated here
 
Test Resources folder has the Feature files

## API Test Automation Approach

The v2/pet/findByStatus endpoint is accepting 'status' as query parameter with values available, pending and sold. 
To Verify the endpoint, 
We can add a pet using Post/pet endpoint with any of the above status and hit the findByStatus endpoint with the added status and validate the response

Similarly, we can use Put/pet endpoint to update the status for already added pet and hit findByStatus endpoint with the updated status and validate the response

The following scenarios can be convered to test the endpoint

Scenario 1: Validate findByStatus endpoint with single query parameter using only Post
1. Given I have the request body with status available
2. When I call the '{POST}/pet' endpoint
3. Then I get '200' status
4. And I have request with 'status' as 'available'
5. When I call the 'v2/pet/findByStatus' endpoint
6. Then I get'200' status
7. And I Validate the json response and perform schema validation against the json response received

Scenario 2: Validate findByStatus endpoint with two query parameters using only Post
1. Given I have the request body with status available and pending
2. When I call the '{POST}/pet' endpoint
3. Then I get '200' status
4. And I have request with 'status' as 'available' and 'pending'
5. When I call the 'v2/pet/findByStatus' endpoint
6. Then I get'200' status
7. And I Validate the json response and perform schema validation against the json response received

Scenario 3: Validate findByStatus endpoint with all 3 query parameters using only Post
1. Given I have the request body with status available, pending and sold
2. When I call the '{POST}/pet' endpoint
3. Then I get '200' status
4. And I have request with 'status' as 'available', 'pending' and 'sold'
5. When I call the 'v2/pet/findByStatus' endpoint
6. Then I get'200' status
7. And I Validate the json response and perform schema validation against the json response received

Scenario 4: Validate findByStatus endpoint with single query parameter using Post and update by Put
1. Given I have the request body with status available
2. When I call the '{POST}/pet' endpoint
3. Then I get '200' status
4. And I have the request body with status pending to update the exisitng pet
5. When I call the '{PUT}/pet' endpoint
6. The I get '200' status
7. nd I have request with 'status' as 'pending'
8. TAhen I call the 'v2/pet/findByStatus' endpoint
9. Then I get'200' status
10. And I Validate the json response and perform schema validation against the json response received

Scenario 5: Validate findByStatus endpoint with two query parameters using Post and update by Put
1. Given I have the request body with status available and pending
2. When I call the '{POST}/pet' endpoint
3. Then I get '200' status
4. And I have the request body with status sold to update the exisitng pet with pending status
5. When I call the '{PUT}/pet' endpoint
6. The I get '200' status
7. And I have request with 'status' as 'available' and 'sold'
8. Then I call the 'v2/pet/findByStatus' endpoint
9. Then I get'200' status
10. And I Validate the json response and perform schema validation against the json response received

**Libraries to Use**

I will be using .Net Http client Library with Speclow and C#. For Asserting the response NUnit framework can be used. 
The .Net Http client librabry has HttpRequestMethod to gather the request details. And SendAsync method to send the request gathered and get the response. For Ex:

public async Task<HttpResponseMessage> GetFindByStatusApiResponseAsync(Dictionary<string, string> queryParameters)
    {
        var request = new HttpRequestMessage()
        {
            Method = HttpMethod.Get,
            RequestUri = new Uri(_httpClient.BaseAddress, QueryHelpers.AddQueryString(findByStatusEndpoint, queryParameters)),
        };

        var response = await _httpClient.SendAsync(request);
        return response;
    }
    
The Specflow plugin has context injection to get the request details from specflow feature file and add the response into a variable which can be used and validated in any class .



