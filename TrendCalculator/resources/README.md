# Trend Calculator

The algorithm will expect a list of numbers.  Whole and/or decimals.

If the supplied list is empty or or does not exist (null), then the trend calculator should return null.

If the list contains only a single value, then the trend calculator should return a value of 0.

The resulting trend will always start with a value of 0.

The first pair will contain the first two numbers of the list.

The second pair will contain the second and third numbers of the list, and so on until the list is completely processed.

The final pair will be the last two numbers of the list.

The order of the list will be determined by the original order passed to the calculator.  No additional sorting will be required.

The following calculations will be applied to each pair.  Pairs will be denoted [p1, p2]

- If P1 = 0 and p2 > 0, the value of the pair will be 1.0.
- If p1 = p2, the value of the pair will be 0.0.
- Otherwise, the value of the pair will be (p2 - p1) / p1

The result of each pair will be summed, resulting in the trend value.