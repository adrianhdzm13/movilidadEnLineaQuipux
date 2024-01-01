#language: en

@RUN_FEATURE
Feature: User Login
  This feature describes the various scenarios related
  to user authentication and login functionality.

  @LOGIN @FINES_VALIDATION
  Scenario: User logs in
    Given the user is on the login page
    When the user enters a username and password
    Then the user should be redirected to the main dashboard "Registrado en RUNT:"