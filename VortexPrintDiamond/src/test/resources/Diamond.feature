Feature: Print a diamond starting with 'A'
  With the supplied letter at the widest point

  Scenario: 'A'
    Given the letter A
    When printing a diamond
    Then it should look like
      """
      A
      """

  Scenario: 'B'
    Given the letter B
    When printing a diamond
    Then it should look like
      """
       A
      B B
       A
      """

  Scenario: first line of 'C'
    Given the letter C
    When printing the first line
    Then it should look like
      """
        A
      """

  Scenario: first line of 'E'
    Given the letter E
    When printing the first line
    Then it should look like
      """
          A
      """