# Runs on Leetcode
    # Runtime - O(n)
    # Space - O(n) where n is length of nums array

class Solution:
    def maxSumAfterPartitioning(self, nums: List[int], K: int) -> int:
        if not nums:
            return 0
        
        dp = [0 for j in range(len(nums))]
        
        for i in range(len(dp)):
            temp = 0
            j = 1
            while j <= K and i-j+1 >= 0:
                temp = max(temp, nums[i-j+1])
                x = 0
                if i >= j:
                    x = dp[i-j]
                dp[i] = max(dp[i], x + (temp * j))
                j += 1

        return dp[-1]
