Feature: To change the currency

  @Flag
  Scenario: To change currency type
    Given I am on DP HomePage
    When  I click on Flag icon and change the country to "United States"
    Then  I should be able to see the respective Country Currency


  @socialIcons
  Scenario: To verify social pages
    Given I am on DP HomePage
    When  I click on icon
    Then  I should be redirected to that page

  @NewInTab
  Scenario: To check various new products in NewIn category
    Given I am on DP HomePage
    When  I click on New In Shoes & Boots
    Then  I should be able to list of shoes and boots available

  @ClothingTab
  Scenario: To check various  products in Clothing category
    Given I am on DP HomePage
    When  I am on skirts link
    Then  I should be able to list of skirts avaialble on site