Feature: New user registration.

  Scenario: Verification of successful registration when the inputs are correct.
    Given the user on the user registration page.
    When user enter valid data on the page
      | Fields     | Values |
      | First Name | Raam   |
      | Last Name  | Ravuri |
    Then the user registration should be successful.
