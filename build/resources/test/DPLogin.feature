Feature: Login in to Dorothy Perkins Application

  @login
  Scenario Outline: Login in to DP
    Given  I am on DP LoginPage
    When   I enter <Username> and <Password>
    Then   I should be logged in successfully
    Examples:
      | Username                   | Password  |
      | sraavanthi.thuma@gmail.com | shrav@123 |
      #| sraavanthi.thuma@gmail.com | Shrav@123 |

  @loginfail
  Scenario Outline: Login in to DP
    Given  I am on DP LoginPage
    When   I enter <Username> and <Password>
    Then   Login <Message> should be displayed

    Examples:
      | Username                   | Password  | Message                                                       |
      | sraavanthi.thuma@gmail.com | Shrav@123 | We do not recognise this email or password, please try again. |