# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        -BFS/DFS not work here because how to differentiate a 
        square when we go on the next cell
        
        -iterate to find a '1'(this is starting point) then find square by going diagonal                   traversal .
        -everytime go diagonal find min of(up, topleft, and left)+1
        
        """
        if not matrix:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        maxVal = 0
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j],dp[i][j-1])+1
                maxVal = max(maxVal, dp[i][j])
                
        print(dp)
        return maxVal*maxVal
    