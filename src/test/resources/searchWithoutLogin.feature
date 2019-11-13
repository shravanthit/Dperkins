Feature: Search products

  Scenario Outline: Search for a product without login

    Given I am on DP HomePage
    When  I search for <product>
    Then  List of products for <product> should be displayed

    Examples:
    |product|
    |shoes  |