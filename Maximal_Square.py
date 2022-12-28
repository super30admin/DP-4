import numpy as np
class Solution:
    # TC: O(m*n)
    # SC: O(m*n)
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        dp = np.zeros((m+1, n+1))
        max_area = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    max_area = max(max_area, dp[i][j])

        return int(max_area * max_area)

    # TC: O(m*n)
    # SC: O(n)
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        dp = np.zeros(n+1)
        max_area = 0

        for i in range(1, m+1):
            diag = 0
            for j in range(1, n+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j-1], dp[j], diag) 
                    max_area = max(max_area, dp[j])
                else:
                    dp[j] = 0
                
                diag = temp

        return int(max_area * max_area)
