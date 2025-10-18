# Time is O(m*k)
# Space is O(m) for using memo and recursion depth stack

# The intuition is to use a for based recursion approach to split the partitions. In each partition determine the highest value and calculate the curr partition value.
# Finally add that to the recursive partition and return the max of that.

class Solution:
    def maxSumAfterPartitioningTopDown(self, arr: List[int], k: int) -> int:
        self.memo = {}

        def helper(i):
            if i == len(arr): return 0
            if i in self.memo:
                return self.memo[i]
            maxResult = 0
            maxPartition = arr[i]
            for j in range(1, k + 1):
                if (i + j - 1) < len(arr):
                    maxPartition = max(maxPartition, arr[i + j - 1])
                    currPartition = maxPartition * j
                    maxResult = max(maxResult, currPartition + helper(i + j))
            self.memo[i] = maxResult
            return self.memo[i]

        return helper(0)

    #Time is O(m*k)
    #Space O(m) for dp array

    # This is a bottom up solution, the logic behind is similar top down. First we calculate the maxInPartition checking boundary conditions. Then curr partition with total.
    # Finally maximum of max result and total add it to dp array and return the last element.
    def maxSumAfterPartitioningBottomUp(self, arr: List[int], k: int) -> int:
        dp = [0] * len(arr)
        dp[0] = arr[0]
        for i in range(len(arr)):
            maxResult = 0
            maxInPartition = arr[i]
            for j in range(1, k+1):
                if (i-j+1) >= 0:
                    maxInPartition = max(maxInPartition, arr[i-j+1])
                    currPartition = maxInPartition * j
                    total = currPartition
                    if (i-j) >= 0:
                        total = currPartition + dp[i-j]
                maxResult = max(maxResult, total)
            dp[i] = maxResult

        return dp[len(arr) - 1]



