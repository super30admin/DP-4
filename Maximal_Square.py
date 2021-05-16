class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        m , n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        #dp = [[0]*(n+1)]*(m+1)
        #print(dp)
        max_val=0
        for i in range(1,len(dp)):
            #print(dp)
            for j in range(1,len(dp[0])):                
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1            
                max_val = max(dp[i][j],max_val)
                #print(dp)
        #print(dp)
        return max_val*max_val
        
