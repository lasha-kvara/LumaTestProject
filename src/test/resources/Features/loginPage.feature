Feature: Login Page Feature

  Scenario: Login Page Title
    Given User is on main page
    When User click SignIn Button
    When User gets the title of the page
    Then Page title should be "Customer Login"

  Scenario: Verify Login Page Elements
    Given User is on main page
    When User click SignIn Button
    Then Search field should be visible
    And Cart button could be visible
    Then Navigation section should be visible
    Then Email field should be visible
    And Password field should be visible
    And Sign In Account button should be visible
    And Forgot your password button should be visible
    And Create an account button should be visible

  Scenario: Verify Login Page Required Fields
    Given User is on main page
    When User click SignIn Button
    Then User click SignIn Account Button
    And Email field error should be visible
    And Password field error should be visible
    Then User enters email input with wrong email: "SomeEmail@gmail.com"
    Then User click SignIn Account Button
    And Password field error should be visible
    Then Clear email field
    And User enters password input with wrong password: "SomePassword"
    Then User click SignIn Account Button
    And Email field error should be visible

  Scenario: Login With Wrong Account
    Given User is on main page
    When User click SignIn Button
    Then User enters email input with wrong email: "Wrongemail@gmail.com"
    Then User enters password input with wrong password: "WrongPassword"
    When User click SignIn Account Button
    Then Error message should be visible

  Scenario: Login With Active Account
    Given User is on main page
    When User click SignIn Button
    Then User enters email input with active email: "ricksanchez@gmail.com"
    Then User enters password input with active password: "#qwerty123"
    When User click SignIn Account Button
    Then Welcome Rick Sanchez message should be visible