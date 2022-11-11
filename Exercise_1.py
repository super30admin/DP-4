# Time Complexity: O(m*n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0:
            return
        
        cols = len(matrix[0])
        
        dp = [0]*(cols+1)
        
        diagUp = 0
        res = 0
        
        for i in range(1, len(matrix)+1):
            for j in range(1, len(matrix[0])+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = min(dp[j], dp[j-1], diagUp) + 1
                    res = max(res, dp[j])
                else:
                    dp[j] = 0
                    
                diagUp = temp
        
        return res**2