# Brut force recursion
# Time O(k^n)
# Space O(k+n)
class Solution:
    
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        return self.dfs(arr, k, 0, len(arr))    

    def dfs(self, arr: List[int], k: int, pivot: int, n: int) -> int:
        if pivot == n: return 0
        maxRes = 0
        maxNum = 0
        i = pivot
        while i < pivot+k and i < n:
            maxNum = max(maxNum, arr[i])
            currPartitionVal = maxNum * (i - pivot + 1)
            maxRes = max(maxRes, currPartitionVal + self.dfs(arr, k, i + 1, n))
            i += 1
        return maxRes

# Memoization
# Time O(k^n)
# Space O(k+n)
class Solution:
    def __init__(self):
        self.memo = None
        
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        self.memo = [-1] * n
        return self.dfs(arr, k, 0, n)    

    def dfs(self, arr: List[int], k: int, pivot: int, n: int) -> int:
        if pivot == n: return 0
        if self.memo[pivot] != -1: return self.memo[pivot]
        maxRes = 0
        maxNum = 0
        i = pivot
        while i < pivot+k and i < n:
            maxNum = max(maxNum, arr[i])
            currPartitionVal = maxNum * (i - pivot + 1)
            maxRes = max(maxRes, currPartitionVal + self.dfs(arr, k, i + 1, n))
            i += 1
        self.memo[pivot] = maxRes
        return maxRes
    
# DP
# Time O(n*k)
# Space O(n)
class Solution:
    def __init__(self):
        self.memo = None
        
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        for pivot in range(n):
            maxRes = 0
            maxNum = 0
            i = pivot
            while pivot-k < i <= pivot and 0 <= i < n:
                maxNum = max(maxNum, arr[i])
                currPartitionVal = maxNum * (pivot - i + 1)
                maxRes = max(maxRes, currPartitionVal + dp[i-1])
                i -= 1
            dp[pivot] = maxRes
        return dp[-1]