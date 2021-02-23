"""
Time Complexity : O(n*k)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, at every point, we are calculating the maximum value if we decide to go forward with either single, double
or triple partition. It can be done recursively as well, but we see repeated subproblems there, hence DP.
"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        l = len(arr)
        dp = [0 for i in range(l)]
        for i in range(l):
            maxi = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxi = max(maxi, arr[i-j+1])
                    if i-j >= 0:
                        dp[i] = max(dp[i], maxi*j + dp[i-j])
                    else:
                        dp[i] = max(dp[i], maxi*j)
        return dp[-1]
