# Time Complexity : O(n)
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0:
            return 0

        dp = [0]* (len(arr))

        dp[0] = arr[0]

        for i in range(1,len(arr)):
            _max = arr[i]

            for j in range(1, min(k+1,i+2)):
                _max = max(_max,arr[i-j+1])
                if i -j >= 0:
                    dp[i] = max(dp[i], dp[i-j] + (j * _max))
                else:
                    dp[i] = max(dp[i], (j * _max))

        return dp[-1]


