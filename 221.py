# TC : O(m*n)
# SC = O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        max_side = 0

        m = len(matrix)
        n = len(matrix[0])
        dp = [0] * (n + 1)  # using Dp array
        for i in range(1, m+1):
            temp = dp[0]
            for j in range(1, n +1):
                prev = dp[j]
                if matrix[i-1][j-1] == "1":
                    dp[j] = min(dp[j - 1], dp[j], temp) + 1 # dp[j - 1] incoming element
                    max_side = max(max_side, dp[j])
                else: 
                    dp[j] = 0
                temp = prev
            
                    
        return max_side * max_side

            