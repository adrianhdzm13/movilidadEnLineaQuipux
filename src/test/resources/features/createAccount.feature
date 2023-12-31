#language: en

@CREATE_ACCOUNT
Feature: User Creation
  In order to access the platform
  As a new user
  I want to create an account

  @CREATE_USER
  Scenario: Create a new user
    Given that I am on the registration page
    When the required data is entered and the registration form is submitted
      | tipo | numeroDocumento | nombres | apellidos | pais   | celular    | email                         | confirmarEmail                | password          | confirmarPassword |
      | RNE  | 9148195936      | Adrian  | Hernandez | Brasil | 3228381122 | adrianhdzm00011321209@gmail.com | adrianhdzm00011321209@gmail.com | pruebaGATO*.*2023 | pruebaGATO*.*2023 |
    Then I should see the successful registration message

@VALIDATE_FIELDS
  Scenario: Validate required fields in a form
    Given I am on the create account page
    When I enter incomplete information and submit the form
    Then error messages for the required fields should be displayed "Este campo es obligatorio"