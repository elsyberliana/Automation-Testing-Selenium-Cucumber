@AddProduct
Feature: Add Product

  @AddProduct
  Scenario: Add Product
    Given User is on Login Page
    When User fill username and password
    And User click Login button
    And User should be on Products page
    Then User click Add to cart button
