Feature: Cart Feature

  Scenario: Add Product To Cart
    Given User is on main page
    When User click SignIn Button
    Then User enters email input with active email: "ricksanchez@gmail.com"
    Then User enters password input with active password: "#qwerty123"
    When User click SignIn Account Button
    Then Welcome Rick Sanchez message should be visible

    Then Search "T-Shirt" Product
    And Choose the first product
    And Get price from the product detail page
    Then Remove chars from the price and convert to double
    And Choose size "S"
    And Choose any color
    And Add click to cart
    Then Check add cart success message is displayed

  Scenario: Verify Product Price In Cart
    Given User is on main page
    When User click SignIn Button
    Then User enters email input with active email: "ricksanchez@gmail.com"
    Then User enters password input with active password: "#qwerty123"
    When User click SignIn Account Button
    Then Welcome Rick Sanchez message should be visible

    Then Search "T-Shirt" Product
    And Choose the first product
    And Get price from the product detail page
    Then Remove chars from the price and convert to double
    And Choose size "S"
    And Choose any color
    And Add click to cart
    Then Check add cart success message is displayed

    When Click cart button
    Then Get product price from cart popup
    Then Remove chars from the cart price and convert to double
    Then Verify if the product price is correct in the cart

