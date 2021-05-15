# Time Complexity: O(nk), where n - length of the array, k - maximum length of the sub-array
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr or len(arr) == 0:
            return 0

        n = len(arr)
        # Array to store the maximum sum for every element
        dp = [0 for x in range(n)]

        # For every element, update the max sum of all subarrays from size 1 to k
        for i in range(n):
            maximum = arr[i]
            size = 1
            while size <= k and i - size + 1 >= 0:
                maximum = max(maximum, arr[i - size + 1])

                if i - size >= 0:
                    dp[i] = max(dp[i], dp[i - size] + maximum * size)
                else:
                    dp[i] = max(dp[i], maximum * size)

                size += 1

        # Last element gives the overall largest sum
        return dp[n - 1]