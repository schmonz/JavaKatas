Feature: Print numbers and FizzBuzz
  As a programmer being interviewed
  I want to print some numbers normally and some strangely
  So that I can get this job

  Scenario Outline: Print numbers and FizzBuzz stuff
    Given the number <Number>
    When it is displayed
    Then it is shown as <Output>
    Examples:
    | Number | Output |
    | 1      | 1      |
    | 2      | 2      |
    | 3      | Fizz   |
    | 4      | 4      |
    | 5      | Buzz   |
    | 6      | Fizz   |
    | 7      | 7      |
    | 8      | 8      |
    | 9      | Fizz   |
    | 10     | Buzz   |
    | 11     | 11     |
    | 15     | FizzBuzz |