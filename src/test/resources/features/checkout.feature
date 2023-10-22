@checkout
Feature: Checkout

  @checkout
  Scenario: checkout
    Given User is on Login Page
    When User fill username and password
    And User click Login button
    And User should be on Products page
    And User click Add to cart button
    And User click Cart icon
    When User click Checkout button
    Then User will be redirect to Your Information page
    When User fill firstname and lastname and PostalCode
    And User click continue button
    Then User will be redirect to Overview page
    When User click Finish button
    Then User will be redirect to Complete page
