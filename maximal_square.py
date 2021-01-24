class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        #O(mn)
        #O(mn)
        maxl=0
        #dp[i][j] represents square formed by counting in itself at bottom right corner of square
        #check square box remaining three entries for new computation
        dp = [[0] * (len(matrix[0]) + 1) for i in range(len(matrix) + 1)]
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
                    maxl=max(maxl,dp[i][j])
        #maxl represents max side of square length possible
        return maxl*maxl
                   
        