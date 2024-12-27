"""
Iterate over all indices to form partions with at most k elements
TC: O(n*k)
SP: O(n) to store cache
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        cache = {}
        def dfs(i):
            if i in cache:
                return cache[i]
            curr_max = 0
            res = 0
            for j in range(i, min(len(arr), i+k)):
                curr_max = max(curr_max, arr[j])
                res = max(res, dfs(j+1)+(j-i+1)*curr_max)
            cache[i] = res
            return res
        return dfs(0)