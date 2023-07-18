# Time Complexity : O(nk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        dp = [0 for _ in range(len(arr))]
        dp[0] = arr[0]

        for i in range(1, len(arr)):
            # This one optimizes using incoming element to know if max got bigger, 
            # removing the need to recalculate the maximum in the window everytime
            maxVal = arr[i]
            for j in range(1, min(k+1, i+2)):
                maxVal = max(maxVal, arr[i-j+1])
                if j <= i:
                    dp[i] = max(dp[i], j*maxVal + dp[i-j])
                else:
                    dp[i] = max(dp[i], j*maxVal)
        return dp[len(arr)-1]
