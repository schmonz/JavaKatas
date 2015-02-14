Feature: Convert Roman numerals to decimal
  As a reader of weird old books
  I want to convert Roman numerals to ordinary numbers
  So that I can understand them

  Scenario Outline: Convert Roman to decimal
    Given the Roman numeral <Roman>
    When it is converted to decimal
    Then its value is <Arabic>
    Examples:
    | Roman  | Arabic |
    | I      | 1      |
    | II     | 2      |
    | VI     | 6      |
    | IV     | 4      |
    | IX     | 9      |
    | XC     | 90     |
    | MCMXC  | 1990   |
    | MMVIII | 2008   |
    | XLVII  | 47     |
