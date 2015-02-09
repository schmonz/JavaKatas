Feature: Convert Roman numerals to decimal
  As a reader of weird old books
  I want to convert Roman numerals to ordinary numbers
  So that I can understand them

  Scenario: I
    Given the Roman numeral I
    When it is converted to decimal
    Then its value is 1

  Scenario: II
    Given the Roman numeral II
    When it is converted to decimal
    Then its value is 2

  Scenario: VI
    Given the Roman numeral VI
    When it is converted to decimal
    Then its value is 6

  Scenario: IV
    Given the Roman numeral IV
    When it is converted to decimal
    Then its value is 4
