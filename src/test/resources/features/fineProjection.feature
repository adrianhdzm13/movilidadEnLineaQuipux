#language: en

@RUN_FEATURE
Feature: Fines validation
  This feature verifies the process of displaying and hiding
  fine projections for a user on the public home page.

@FINES_VALIDATION
Scenario: Fines validation
Given the user enters a document number on the public home page
  |identificacion|
  |111           |
When they view and close the fine projection
Then the fine projection should hide "Multas"