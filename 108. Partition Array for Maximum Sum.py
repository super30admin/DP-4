class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0:
            return 0
        size = len(arr)
        dp = [0] * size
        dp[0] = arr[0]  # assignment index 0 of DP same as arr array as 1 element will have no window

        for i in range(1, len(dp)):
            mx = dp[i]  # max initially dp[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    mx = max(mx, arr[i - j + 1])  # max between number of elements in the partition window
                    if i - j >= 0:  # case to check if dp[i] is not negative
                        dp[i] = max(dp[i], (mx * j + dp[i - j]))
                    else:  # if negative we assign the same value
                        dp[i] = mx * j
        return dp[-1]  # return last element

# DP Bottom Up
# Time Complexity : O(n * k)
# Space Complexity : O(n) length of DP array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
