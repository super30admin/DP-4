"""
Problem : 2

Time Complexity : O(n*k)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Partition Array for maximum sum


class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        n=len(arr)
        dp=[0 for _ in range(n)]
        dp[0]=arr[0]
        for i in range(1,n):
            j=1
            maxx=arr[i]
            while j<=k and i-j+1>=0:
                maxx=max(maxx,arr[i-j+1])
                if i-j>=0:
                    dp[i]=max(dp[i],j*maxx+dp[i-j])
                else:
                    dp[i]=max(dp[i],j*maxx)

                j+=1
        return dp[n-1]