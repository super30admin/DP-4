"""
TC: O(n)
SC: O(n)+O(n) (dp array and recursive stack space)
Logic:
Use forward partition logic
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [-1]*len(arr)
        def func(idx):
            max_element = -float('inf')
            max_sum = 0
            if idx == len(arr):
                return 0
            if dp[idx]!=-1:
                return dp[idx]
            length = 0
            for i in range(idx,min(len(arr), idx+k)): #using min(len(arr), idx+k) to prevent out of bounds
                length+=1
                max_element = max(max_element, arr[i])
                max_sum = max(max_sum,length*max_element+func(i+1))
            dp[idx] = max_sum
            return dp[idx]
        return func(0)