@Login
Feature: Verifying Adactin Hotel Login details

  Scenario Outline: Verifying Adactin Hotel Login valid
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify the login success message "Hello Mano220798!"

    Examples: 
      | username   | password |
      | Mano220798 | MANO123  |

  Scenario Outline: Verifying Adactin Hotel Login valid using Enter
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>" with Enter key
    Then User should verify the login success message "Hello Mano220798!"

    Examples: 
      | username   | password |
      | Mano220798 | MANO123  |

  Scenario Outline: Verifying Adactin Hotel Login Invalid Credentials
    Given User is on the Adactin page
    When User should perform login "<username>", "<password>"
    Then User should verify after login with invlaid credentials error message "Invalid Login details or Your Password might have expired."

    Examples: 
      | username   | password  |
      | Mano220798 | MANO12345 |
