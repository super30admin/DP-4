class Solution:
    # Brute Force - TLE on Leetcode
    # Time Complexity - O((mn)^2)
    # Space Complexity - O((mn)^2)
    def maximalSquare(self, matrix) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        max_ = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    valid = True
                    curr = 1
                    while ((i + curr < m) and (j + curr < n) and valid):
                        # check entire row for 1's
                        for k in range(j, (j + curr + 1)):
                            if matrix[i + curr][k] == '0':
                                valid = False
                                break
                        # Check the entire column for 1's
                        for k in range(i, (i + curr + 1)):
                            if matrix[k][j + curr] == '0':
                                valid = False
                                break
                        if valid:
                            curr += 1
                    max_ = max(max_, curr)

        return max_ * max_


class Solution:
    # DP Approach
    # Time Complexity - O((mn))
    # Space Complexity - O((mn))
    def maximalSquare(self, matrix) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        max_ = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == '1':
                    # Take the min of left, top and diagonal elements before and add 1
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    max_ = max(max_, dp[i][j])

        return max_ * max_



class Solution:
    # Optimized dp for space
    # Time Complexity - O((mn))
    # Space Complexity - O((n))
    def maximalSquare(self, matrix) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [0 for _ in range(n + 1)]
        max_ = 0
        diagUp = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == '1':
                    prev = dp[j]
                    dp[j] = min(dp[j - 1], dp[j], diagUp) + 1
                    diagUp = prev
                    max_ = max(max_, dp[j])
                else:
                    dp[j] = 0

        return max_ * max_