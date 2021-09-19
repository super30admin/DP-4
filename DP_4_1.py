class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:        
        
		## TIME COMPLEXITY : O(MxN) ##
		## SPACE COMPLEXITY : O(MxN) ##
        
        
       
        if not matrix or not matrix[0]: return 0
        M, N, dp = len(matrix), len(matrix[0]), [[1 if ch == '1' else 0 for ch in row] for row in matrix] # copyy to dp, string to int conv
        for i in range(1, M):
            for j in range(1, N):
                if matrix[i][j] == '1':
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
        return max(max(row) for row in dp) ** 2
