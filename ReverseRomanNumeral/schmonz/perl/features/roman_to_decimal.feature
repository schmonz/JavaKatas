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

  Scenario: IX
    Given the Roman numeral IX
    When it is converted to decimal
    Then its value is 9

  Scenario: XC
    Given the Roman numeral XC
    When it is converted to decimal
    Then its value is 90

  Scenario: XCIX
    Given the Roman numeral XCIX
    When it is converted to decimal
    Then its value is 99

  Scenario: MCMXC
    Given the Roman numeral MCMXC
    When it is converted to decimal
    Then its value is 1990

  Scenario: MMVIII
    Given the Roman numeral MMVIII
    When it is converted to decimal
    Then its value is 2008

  Scenario: XLVII
    Given the Roman numeral XLVII
    When it is converted to decimal
    Then its value is 47
