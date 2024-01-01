#language: en
@RUN_FEATURE
Feature: User Creation
  In order to access the platform
  As a new user
  I want to create an account

  @CREATE_ACCOUNT @RUN_FEATURE2
  Scenario: Create a new user
    Given that I am on the registration page
    When the required data is entered and the registration form is submitted
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