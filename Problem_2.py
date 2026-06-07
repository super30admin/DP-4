# class Solution:
#     def maxSumAfterPartitioning(self, arr, k):
#         return self.helper(0, arr, k)

#     def helper(self, index, arr, k):
#         if index >= len(arr):
#             return 0

#         maxSum = 0
#         currMax = 0
#         for i in range(1, k + 1):
#             if index + i <= len(arr):
#                 currMax = max(currMax, arr[index + i - 1])
#                 currSum = (currMax * i) + self.helper(index + i, arr, k)
#                 maxSum = max(maxSum, currSum)

#         return maxSum
    
# class Solution:
#     def maxSumAfterPartitioning(self, arr, k):
#         n = len(arr)
#         memo = [-1] * (n)
#         return self.helper(0, arr, k, memo)

#     def helper(self, index, arr, k, memo):
#         if index >= len(arr):
#             return 0
#         if memo[index] != -1:
#             return memo[index]
#         maxSum = 0
#         currMax = 0
#         for i in range(1, k + 1):
#             if index + i <= len(arr):
#                 currMax = max(currMax, arr[index + i - 1])
#                 currSum = (currMax * i) + self.helper(index + i, arr, k, memo)
#                 maxSum = max(maxSum, currSum)
#         memo[index] = maxSum
#         return maxSum


class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        n = len(arr)
        memo = [0] * (n + k)
        for index in range(n - 1, -1, -1):
            maxSum = 0
            currMax = arr[index]
            for i in range(1, k + 1):
                if index + i <= len(arr):
                    currMax = max(currMax, arr[index + i - 1])
                    currSum = (currMax * i) + memo[index + i]
                    maxSum = max(maxSum, currSum)
            memo[index] = maxSum
        return memo[0]


