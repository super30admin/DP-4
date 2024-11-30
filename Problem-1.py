class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        max_ = 0
        m = len(matrix)
        n = len(matrix[0])

        dp = [0] * (n+1)

        for i in range(1,m+1):
            diagUp = dp[0]
            for j in range(1,n+1):
                if(matrix[i-1][j-1] == '1'):
                    temp = dp[j]
                    dp[j] = 1 + min(diagUp,min(dp[j],dp[j-1]))
                    max_ = max(max_,dp[j])
                    diagUp = temp
                else:
                    dp[j] = 0

        return max_ * max_
                    