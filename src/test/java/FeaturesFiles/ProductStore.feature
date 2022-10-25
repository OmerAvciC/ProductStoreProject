Feature: ProductStore Website Testing
  Scenario: Adding and removing products

    Given Customer navigation through product categories: Phones, Laptops and Monitors
    When Navigate to -Laptop- → -Sony vaio iFive- and click on -Add to cart-. Accept pop up confirmation.
    And Navigate to -Laptop- → -Dell iFive eightgb- and click on -Add to cart-. Accept pop up confirmation.
    And Navigate to -Cart- → Delete -Dell iSeven eightgb- from cart.
    And Click on -Place order- and Fill in all web form fields.
    And Click on -Purchase- and Capture and log purchase Id and Amount.
    And Assert purchase amount equals expected
    Then Click on -Ok-
