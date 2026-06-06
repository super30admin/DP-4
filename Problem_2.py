class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        return self.helper(0, arr, k)

    def helper(self, index, arr, k):
        if index >= len(arr):
            return 0

        maxSum = 0
        currMax = 0
        for i in range(1, k + 1):
            if index + i <= len(arr):
                currMax = max(currMax, arr[index + i - 1])
                currSum = (currMax * i) + self.helper(index + i, arr, k)
                maxSum = max(maxSum, currSum)

        return maxSum
