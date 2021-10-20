#Time Complexity : O(n^2)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0: 
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxval = prev = dia = 0
        dp = [0]*(n+1)
        for i in range(1,m+1):
            for j in range(1,n+1):
                prev = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j-1], min(dp[j], dia))
                    maxval = max(maxval, dp[j])
                  
                else:
                    dp[j] = 0
                dia = prev
               
        
        return maxval*maxval
        