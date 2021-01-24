class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        # https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/901220/Python-Short-and-Simple-Top-Down-DP-Explained
        #https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP
        N = len(arr)
        dp = [0] * (N + 1)
        for i in xrange(N):
            curMax = 0
            for j in xrange(1, min(k, i + 1) + 1):
                curMax = max(curMax, arr[i - j + 1])
                dp[i] = max(dp[i], dp[i - j] + curMax * j)
        return dp[N - 1]
        