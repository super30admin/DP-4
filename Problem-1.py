'''
    Time Complexity: O(mn)
    Space Complexity: O(n)
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maximum = 0
        dp = [0 for j in range(n+1)]

        for i in range(m):
            diagUp = 0
            for j in range(1, n+1):
                temp = dp[j]
                if matrix[i][j-1] == "1":
                    dp[j] = 1+min(diagUp, min(dp[j], dp[j-1]))
                    maximum = max(maximum, dp[j])
                else:
                    dp[j] = 0

                diagUp = temp

        return maximum*maximum