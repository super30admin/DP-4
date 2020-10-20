#Time - O(M*N)
#Space - O(M*N)
# using dp tabular method and global max. 


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        dp = [[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        
        result = 0
        
        
        for i in range(1,len(matrix)+1):
            for j in range(1,len(matrix[0])+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                    result = max(result, dp[i][j])
                    
        return result*result
