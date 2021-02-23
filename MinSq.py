#Time O(M*N)
#Space O(M*N)


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 
        
        dp = [[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        maxSq = 0
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1+min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    maxSq = max(maxSq, dp[i][j])
                    
                    
        return maxSq * maxSq
