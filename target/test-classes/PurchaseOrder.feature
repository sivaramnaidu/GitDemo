@tag
Feature: Purchase order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> password <password> 
    When I add product <productName> to cart
    And Checkout <productName> to cart
    Then "Thankyou for order." message display on confirmation page

    Examples: 
      | name         | password       | productName |
      | sivaramnaidu |     Akhil@9963 |ZARA COAT 3  |
      
