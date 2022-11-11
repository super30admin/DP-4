# Time Complexity: O(n*k) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        dp = [0]*len(arr)
        dp[0] = arr[0]
        
        for i in range(1, len(arr)):
            m = dp[i]
            for j in range(1, k+1):
                if (i-j+1)>=0:
                    m = max(m, arr[i-j+1])
                    if i-j>=0:
                        dp[i] = max(dp[i], m*j + dp[i-j])
                    else:
                        dp[i] = max(dp[i], m*j)

        return dp[-1]