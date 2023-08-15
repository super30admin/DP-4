# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        n = len(arr)
        dp = ([0] * n)
        for j in range(k): 
            dp[j] = (max(arr[:j + 1]) * (j + 1))
        for j in range(k,n):
            curr = []
            for m in range(k):
                curr.append(dp[j-m-1] + (max(arr[(j-m):(j+1)]) * (m+1)))
            dp[j] = max(curr)
        return dp[-1]