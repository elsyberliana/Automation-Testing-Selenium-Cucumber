@RegressionLogin
Feature: Login

  @Test1
  Scenario: Login
    Given User is on Login Page
    When User fill username and password
    And User click Login button
    Then User will redirect to Products page

@Test2
Scenario: Login Invalid
  Given User is on Login Page
  When User fill invalid username and password
  And User click Login button
  Then User will get error message

