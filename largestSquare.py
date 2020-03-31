'''
Effecient:
Time Complexity: O(n^2)
Space Complexity: O(n^2)
Explanation: Use the logic to find the length of the square from the neighboring cells. Use the following conditions
to find the DP solution:
If i == 0 or j ==0: length =0
if [i][j] == 0 length = 0
if [i][j] == 1 length =  1 + min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])

BruteForce:
Time Complexity: O((mn^2)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Iterate through the matrix from the diagonals (bottom and right) and keep checking if it is a square, if
even once you see a '0', end the current search. contiue until u see a 0 or reach the end and save the largest square
size on the way.
'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        # +1 because first few rows and columns are 0

        rows = len(matrix)

        if rows > 0:
            col = len(matrix[0])
        else:
            col = 0

        dp = [[0 for i in range(col + 1)] for j in range(rows + 1)]

        maxL = 0

        for i in range(1, (rows + 1)):
            for j in range(1, (col) + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = 1 + min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
                    maxL = max(maxL, dp[i][j])

        return maxL * maxL

    def maximalSquareBruteForce(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        rows = len(matrix)
        col = len(matrix[0])
        maxSqlen = 0
        for i in range(0, rows):
            for j in range(0, col):
                if matrix[i][j] == '1':
                    sqlen = 1
                    flag = True

                    while sqlen + i < rows and sqlen + j < col and flag:
                        for k in range(j, sqlen + j + 1):
                            if matrix[i + sqlen][k] == '0':
                                flag = False
                                break
                        for k in range(i, sqlen + i + 1):
                            if matrix[k][j + sqlen] == '0':
                                flag = False
                                break
                        if flag:
                            sqlen += 1
                    maxSqlen = max(maxSqlen, sqlen)

        return maxSqlen * maxSqlen
