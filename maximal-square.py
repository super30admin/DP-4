"""
Runtime Complexity:
O(m*n)  - because we traverse 'm' rows and 'n' columns respecitvely to find the maximal square.
Space Complexity:
O(n) - dp array which stores all the columns.
Yes, the code worked on leetcode.
Issues while coding - No
"""

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix)==0:
            return 0
        max_ = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [0 for i in range(n+1)]
        prev,temp = 0,0
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                temp  = dp[j]
                if matrix[i-1][j-1]=='1':
                    dp[j] = min(dp[j-1],min(dp[j],prev))+1
                    max_ = max(max_,dp[j])
                else:
                    dp[j] = 0
                prev = temp
        return max_*max_
        
        