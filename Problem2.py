# https://leetcode.com/problems/partition-array-for-maximum-sum/description/
# TC: k^n
# SC: O(n)
class Solution:
    maxim = 0
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        self.helper(arr, k, 0, 0)
        return self.maxim

    def helper(self, arr, k, i, sum):

        if i == len(arr):
            self.maxim = max(self.maxim, sum)
            return 

        currMax = 0
        for j in range(1, k + 1):
            if i + j - 1 >= len(arr):
                break
            currMax = max(currMax, arr[i+j-1])
            self.helper(arr, k, i+j, sum + currMax * j)

# TC: k^n
# SC: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        return self.helper(arr, k, 0, 0)

    def helper(self, arr, k, i, sum):

        if i == len(arr):
            return sum
            
        maxim = 0
        currMax = 0
        for j in range(1, k + 1):
            if i + j - 1 >= len(arr):
                break
            currMax = max(currMax, arr[i+j-1])
            maxim = max(maxim, self.helper(arr, k, i+j, sum + currMax * j))

        return maxim

# DP with tabulation (1D array)
# TC: O(n*k)
# SC: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(1, n):
            currMax = 0
            for j in range(1, k+1):
                if i-j+1 < 0:
                    break
                currMax = max(currMax, arr[i-j+1])

                if i-j >= 0:
                    dp[i] = max(dp[i], (dp[i-j] + currMax * j))
                else:
                    dp[i] = max(dp[i], currMax * j)

        return dp[n-1]