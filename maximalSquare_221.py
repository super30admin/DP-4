# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
#Brute Force: Figuring out all va;id squares from all elements. When 1 is encountered, move diagonal from that element-go left until 1s are found until that element's column and move up until 1s are present till the row of the element. This would take O(m*n) time for single element. Do this for all elements and it would take O(m*n*m*n) time.
#Optimal: Make a DP matrix where you fill value of max square array that can be made using that element and what we have calculatee before. If 1: Calculate using this: min value of (left, diagonal left and right) +1. Getting min value+1 ensures we don't have zero in our answer. If 0: fill 0 and do nothing. Update max variable along the way and return area using that.


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if matrix == None or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        n = len(matrix)
        m =len(matrix[0])
        mx = 0
        dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
        
        for i in range(1,n+1):
            for j in range(1,m+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j])
                    mx = max(mx, dp[i][j])
                else:
                    dp[i][j] = 0
  
        return mx*mx
        