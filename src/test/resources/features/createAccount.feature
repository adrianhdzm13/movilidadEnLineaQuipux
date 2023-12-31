#language: en
@RUN_FEATURE
Feature: User Creation
  In order to access the platform
  As a new user
  I want to create an account

  @CREATE_ACCOUNT
  Scenario: Create a new user
    Given that I am on the registration page
    When the required data is entered and the registration form is submitted
      | tipo | numeroDocumento | nombres | apellidos | pais   | celular    | email                           | confirmarEmail                  | password          | confirmarPassword |
      | RNE  | 8836195936      | Adrian  | Hernandez | Brasil | 3228381122 | adrianhdzm10971_209@gmail.com | adrianhdzm10971_209@gmail.com | pruebaGATO*.*2023 | pruebaGATO*.*2023 |
    Then I should see the successful registration message

  @VALIDATE_FIELDS
  Scenario: Validate required fields in a form
    Given I am on the create account page
    When I enter incomplete information and submit the form
    Then error messages for the required fields should be displayed "Este campo es obligatorio"

  @VALIDATE_EMAIL
  Scenario: Validate email format and phone number
    Given I am on the create account page
    When I enter valid email and phone number
      | email                 | phone      |
      | pruebas2023@gmail.com | 3212733880 |
    And I enter invalid email and phone number
      | email                | phone |
      | pruebas2023gmail.com |       |
    Then error messages should be displayed for both fields