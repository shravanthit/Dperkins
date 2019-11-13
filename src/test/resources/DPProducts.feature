Feature: add product to basket and make payment

  @searchForAProduct
  Scenario: adding product to basket and checking payment type
    Given I am on DP LoginPage
    And   I login with credentials sraavanthi.thuma@gmail.com and shrav@123
    #And  I search for a <product>
    #And  I select a random product from the list
    #And  I fill in my details and continue to payments
    #Then I should be on payments page
    When  I search for shoes in searchbar and select a random product
    And   I add to basket and checkout
    Then  I should be on Delivery page