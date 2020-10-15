# 221. Maximal Square

# Approch: DP -> surround the matrix with '0', at each index in the matrix take the value itself and add it with the min(of it's surrounding three values)
# Keep track of max val and return the square of it.

# Code:

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        dp = [[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        
        res = 0
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[i])):
                if int(matrix[i-1][j-1])==0:
                    dp[i][j] = 0
                else:
                    dp[i][j] = int(matrix[i-1][j-1]) + min(min(int(dp[i-1][j]), int(dp[i][j-1])), int(dp[i-1][j-1]))
                res = max(res, dp[i][j])
        
        # print(dp)
        return res*res
                
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Accepted on Leetcode: YES!