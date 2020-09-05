Feature: Admin Fuctionality Validation
  I want validate the Admin

  Scenario Outline: register Into FaceBook
    Given User Launch the "<Browsers>"
    When User Open the Application URL "https://fb.com"
    And User enters Email as "<UserName>" and Password as "<Password>"
    Then Click on Login Button
    And Close the Browser

    Examples: 
      | Browsers | UserName                  | Password       |
      | Chrome   | lakshman.ravuri@gmail.com | lakshman@12345 |
    #  | Chrome   | raam.ravuri@gmail.com     | lakshman@12345 |
