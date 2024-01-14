"""
Time Complexity : O(nk) where n is the length of the arr and k is the partition
Space Complexity :  O(n) where n is the length of the arr

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes
"""


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        for i in range(1, n):
            maxEle = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxEle = max(maxEle, arr[i-j+1])
                    if i-j >= 0:
                        curr = maxEle * j + dp[i-j]
                    else:
                        curr = j * maxEle
                    dp[i] = max(dp[i], curr)

        return dp[n-1]
