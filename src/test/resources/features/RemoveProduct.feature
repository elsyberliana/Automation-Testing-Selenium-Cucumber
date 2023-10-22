@RemoveProduct
Feature: Remove Product

  @RemoveProduct
  Scenario: Remove Product
    Given User is on Login Page
    When User fill username and password
    And User click Login button
    And User should be on Products page
    And User click Add to cart button
    And User click Cart icon
    Then User click remove button
