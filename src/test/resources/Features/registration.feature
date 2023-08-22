Feature: Registration Page Feature

  Scenario: Registration Page Title
    Given User is on main page
    When User click create account Button
    When User gets the title of the registration page
    Then Registration Page title should be "Create New Customer Account"

  Scenario Outline: Registration With Invalid Email
    Given User is on main page
    When User click create account Button
    Then User enters first name with "Rick"
    And User enters last name with "Sanchez"
    And User enters invalid format of email with "<invalidEmail>"
    And User enters password with "SomePassword#123"
    And  User inputs confirm password with "SomePassword#123"
    When User click create account confirmation Button
    Then Invalid email error should be displayed

    Examples:
    | invalidEmail  |
    | RickSanchez   |
    | Rick Sanchez  |
    | 12345678      |
    | RickSanchez@  |
    | RickSanchez1  |
    | RickSanchez@2 |
    | RickSanchez.g |

  Scenario: Registration With Valid Email
    Given User is on main page
    When User click create account Button
    Then User enters first name with "Rick"
    And User enters last name with "Sanchez"
    And User enters valid format of random email
    And User enters password with "SomePassword#123"
    And  User inputs confirm password with "SomePassword#123"
    When User click create account confirmation Button
    Then Registration success message should be displayed
