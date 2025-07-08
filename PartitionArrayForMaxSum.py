from typing import List
# class Solution:
#     def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
#         dp = [0]*len(arr)
#         dp[0] = arr[0]
#         for i in range(1,len(arr)):
#             maxval = arr[i]
#             for j in range(1,k+1):
#                 if i-j+1<0:
#                     break
#                 # incoming
#                 curr = arr[i-j+1]
#                 maxval = max(curr, maxval)
#                 if i-j>=0:
#                     dp[i] = max(dp[i], dp[i-j]+(maxval*j))
#                 else:
#                     dp[i] = max(dp[i], maxval*j)
#         return dp[len(arr)-1]
        
# class Solution:
#     def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
#         def dfs(i):
#             if i == len(arr):
#                 return 0  # base case: end of array
            
#             max_sum = 0
#             max_val = 0
#             for j in range(i, min(i + k, len(arr))):
#                 max_val = max(max_val, arr[j])  # max in current partition
#                 length = j - i + 1
#                 current = max_val * length + dfs(j + 1)
#                 max_sum = max(max_sum, current)
#             return max_sum
        
#         return dfs(0)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        cache = [-1] * n  # Initialize cache with -1 meaning "not computed yet"
        def dfs(i):
            if i == len(arr):
                return 0  # base case: end of array
            if cache[i]!=-1: return cache[i]
            max_sum = 0
            max_val = 0
            for j in range(i, min(i + k, len(arr))):
                max_val = max(max_val, arr[j])  # max in current partition
                length = j - i + 1
                current = max_val * length + dfs(j + 1)
                max_sum = max(max_sum, current)
            cache[i] = max_sum
            return max_sum
        
        return dfs(0)
        
        