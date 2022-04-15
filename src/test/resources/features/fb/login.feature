@all @fblogin @qe3
Feature: :  FB - Login
  As a user
  I want to perform login on facebook
  but I can't see my news feed due to FB restriction

  Scenario:  User failed to login FB
    Given  I open facebook login page
    When   I input email and password
    And    I click button login
    Then   I can't see my news feed
    But    I see FB has disabled my account
