#language: en

@RUN_FEATURE
Feature: User Login
  This feature describes the various scenarios related
  to user authentication and login functionality.

  @LOGIN
  Scenario: User logs in
    Given the user is on the login page
    When the user enters a username and password
      | email                   | password         |
      | adrian.hdz013@gmail.com | pruebasGATO*2023 |
    Then the user should be redirected to the main dashboard "Registrado en RUNT:"