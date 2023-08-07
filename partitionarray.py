# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
    def maxSumAfterPartitioning(self, A, K):
        N = len(A)
        dp = [0] * (N + 1)
        for i in xrange(1, N + 1):
            curMax = 0
            for k in xrange(1, min(K, i) + 1):
                curMax = max(curMax, A[i - k])
                dp[i] = max(dp[i], dp[i - k] + curMax * k)
        return dp[N]