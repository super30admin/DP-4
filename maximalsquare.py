#// Time Complexity : O(n * m) 
# // Space Complexity : O(n * m) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : I saw the class vide and then didi the problem

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n=len(matrix)
        m=len(matrix[0])
        maxDiagonal=0
        dp=[[ 0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        for i in range(1,len(matrix)+1):
            for j in range(1,len(matrix[0])+1):
                if matrix[i-1][j-1]=="1":
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
                    maxDiagonal=max(maxDiagonal,dp[i][j])
        return maxDiagonal*maxDiagonal

# Approach:
# The problem can be solved using dynamic programming. We create a 2D array dp where dp[i][j] represents
# the size of the square with the bottom right corner at matrix[i-1][j-1]. If matrix[i-1][j-1] is 1, we
# update dp[i][j] to be the minimum of dp[i-1][j], dp[i-1][j-1], and dp[i][j-1] plus 1. This is
# because the size of the square is determined by the minimum size of the squares above, to the left
# and to the top left. We also keep track of the maximum diagonal size seen so far.
