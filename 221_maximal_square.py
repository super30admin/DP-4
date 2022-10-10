"""
## Problem 221: Maximal square

## Author: Neha Doiphode
## Date:   10-04-2022

## Description:
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

## Examples:
    Example 1:
        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
                        1   1   0   0   0
                        1   0   1   1   1 ---| largest square containing only 1s
                        1   1   1   1   1 ---|
                        1   0   0   1   0
        Output: 4

    Example 2:
        Input: matrix = [["0","1"],["1","0"]]
        Output: 1

    Example 3:
        Input: matrix = [["0"]]
        Output: 0

## Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.

## Time complexity: Please refer to respective doc-strings of different approaches used below.

## Space complexity: Please refer to respective doc-strings of different approaches used below.

"""

from typing import List, Optional

def get_input():
    print("Enter number of rows in the matrix: ", end = "")
    rows = int(input())
    print("Enter number of columns in the matrix: ", end = "")
    columns = int(input())
    inp_list = []
    print("Enter elements in each row with spaces.")
    for row in range(rows):
        print(f"Row {row + 1}: ", end = "")
        r = input()
        r = [ele for ele in r.split()]
        if len(r) > columns or len(r) < columns:
            raise IndexError(f"Number of columns entered is not as expected. There should be {columns} columns.")
        inp_list.append(r)

    return inp_list

class Solution:
    def maximalSquare_brute_force(self, matrix: List[List[str]]) -> int:
        ################ TIME LIMIT EXECEEDED #################
        """
        Time complexity : O(m * n)^2 where m is number of rows and n is number of columns,
                                     we are running m * n loop inside which we first keep changing rows
                                     and them keep changing columns to form squares and check if bounded squares have all 1s.

        Space complexity: O(1), no auxiliary space is used.
        """
        max_area = 0
        rows = len(matrix)
        columns = len(matrix[0])

        for row in range(rows):
            for col in range(columns):
                flag = False
                if matrix[row][col] == '1':
                    flag = True
                    current = 1
                    while row + current < rows and col + current < columns and flag:
                        for k in range(row + current, row - 1, -1):
                            if matrix[k][col + current] == '0':
                                flag = False
                                break

                        if flag == True:
                            for k in range(col + current, col - 1, -1):
                                if matrix[row + current][k] == '0':
                                    flag = False
                                    break

                        if flag == True:
                            current = current + 1

                    max_area = max(max_area, current)


        return max_area * max_area

    def maximalSquare_dp(self, matrix: List[List[str]]) -> int:
        """
        Time complexity : O(m * n)   where m is number of rows and n is number of columns,
                                     We are traversing each element in the 2D matrix only once.

        Space complexity: O(m * n), auxiliary dp array is created which has m + 1 rows and n + 1 columns
        """
        if len(matrix) == 0:
            return 0

        max_area = 0
        rows = len(matrix)
        columns = len(matrix[0])
        dp = [[0 for col in range(columns + 1)] for row in range(rows + 1)]

        for row in range(1, rows + 1):
            for col in range(1, columns + 1):
                if matrix[row - 1][col - 1] == '1':
                    dp[row][col] = min(min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1
                    max_area = max(max_area, dp[row][col])
        return max_area * max_area

    def maximalSquare_space_improved_dp(self, matrix: List[List[str]]) -> int:
        """
        Time complexity : O(m * n)   where m is number of rows and n is number of columns,
                                     We are traversing each element in the 2D matrix only once.

        Space complexity: O(n), auxiliary dp array is created which has single row with n + 1 columns
        """
        if len(matrix) == 0:
            return matrix

        max_area = 0
        rows = len(matrix)
        columns = len(matrix[0])
        previous = temp = 0
        dp = [0 for col in range(columns + 1)]

        for row in range(1, rows + 1):
            for col in range(1, columns + 1):
                """
                When we used 2D dp array in approach 2, we added 1 extra row and column.
                While generating the dp array, when first row gets generated,
                we move from column 0 to column n.
                when we move to col 1, previous = col 0.

                So we need 3 values.
                1. so we store temp = dp[col]
                   Because when column is incremented temp becomes previous col value(diagonal value which we used in 2D dp array.)
                2. left side value would be current col - 1
                3. current value is the value above in the same column of 2D dp array, as we have not "yet" updated it.

                    0    0   0   0   0
                0   1    1   0   0   0     <=====   1   1   0   0   0
                0                                   1   0   1   1   1
                0                                   1   1   1   1   1
                0                                   1   0   0   1   0

                """

                temp = dp[col]
                if matrix[row - 1][col - 1] == '1':
                    dp[col] = min(dp[col], dp[col - 1], previous) + 1
                    max_area = max(max_area, dp[col])
                else:
                    dp[col] = 0

                previous = temp

        return max_area * max_area


# Driver code
solution = Solution()
matrix = get_input()
print()
print(f"Input: Matrix: {matrix}")
print(f"Output: Approach 1: Brute Force                            : Maximal sqaure area: {solution.maximalSquare_brute_force(matrix)}")
print(f"Output: Approach 2: Dynamic Programming                    : Maximal sqaure area: {solution.maximalSquare_dp(matrix)}")
print(f"Output: Approach 3: Dynamic programming with improved space: Maximal sqaure area: {solution.maximalSquare_space_improved_dp(matrix)}")
print()
