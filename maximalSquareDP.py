class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None:
            return None
        
        m,n = len(matrix), len(matrix[0])
        dp = [[0]*(n+1) for i in range(m+1)]
        maxVal = 0
        
        for i in range(1, len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1]=='1':
                    dp[i][j] = min(dp[i][j-1], min(dp[i-1][j],dp[i-1][j-1]))+1
                    maxVal = max(maxVal, dp[i][j])
                    
        return maxVal*maxVal
    
