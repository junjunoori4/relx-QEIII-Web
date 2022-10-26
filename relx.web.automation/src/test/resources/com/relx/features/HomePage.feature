Feature: Home page feature

  Background: 
    Given user has logged into application
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario: SwagLabs E2E scenario verification
    And user navigates to homepage with header 'PRODUCTS'
    And I filter price from high to low
    And I validate the selected filter 'Price (high to low)'
    And I add cheapest and second costliest items to basket
    And I click on cart icon
    And I validate navigation to cart page with header 'YOUR CART'
    And I validate the items in cart
    And I click checkout button
    And I validate navigation to checkout page with header 'CHECKOUT: YOUR INFORMATION'
    And I enter below personal details
      | FirstName | LastName   | PostalCode |
      | Manoj     | Junjunoori | M14 7BB    |
    And I click continue button
    And I validate navigation to overview page with header 'CHECKOUT: OVERVIEW'
    And I validate total price in cart
    When I click on finish button
    Then I should navigate to order confirmation page with header 'CHECKOUT: COMPLETE!'
