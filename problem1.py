# Time Complexity : Exponentinal
# Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        _max = 0
        for i in range(0, m):
            for j in range(0, n):
                if matrix[i][j] == "1":
                    isValid = True
                    curr = 1

                    while i + curr < m and j + curr < n and isValid:

                        for k in range(j, j + curr + 1):
                            if matrix[i + curr][k] == '0':
                                isValid = False
                                break

                        for k in range(i, i + curr + 1):
                            if matrix[k][j + curr] == '0':
                                isValid = False
                                break

                        if isValid:
                            curr += 1
                    _max = max(_max, curr)

        return _max * _max


# Approach 2:
# Time Complexity : O(m*n)
# Space Complexity: O(m*n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        dp = [[0] * (n + 1) for i in range(m + 1)]

        _max = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
                    _max = max(_max, dp[i][j])

        return _max * _max


# Approach 3:
# Time Complexity : O(m*n)
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        dp = [0] * (n + 1)

        _max = 0
        prev = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    temp = dp[j]
                    dp[j] = min(dp[j], min(dp[j - 1], prev)) + 1
                    _max = max(_max, dp[j])
                    prev = temp
                else:
                    dp[j] = 0

        return _max * _max







