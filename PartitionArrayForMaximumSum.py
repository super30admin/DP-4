'''
TC: O(n*k) - n is the length of the list and k is the partition limit
SC: O(n) - we created a new dp list to store the max value till each point
'''
from typing import List

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0 for i in arr]
        res = -float("inf")
        for i,num in enumerate(arr):
            maxVal = num
            count = 1
            for j in range(i, i-k ,-1):
                if j>=0:
                    maxVal = max(maxVal, arr[j])
                    temp = maxVal*count + dp[j-1] if j-1>=0 else maxVal*count
                    res = max(res, temp)
                    count += 1
            dp[i] = res
        return dp[-1]
s = Solution()
print(s.maxSumAfterPartitioning([1,15,7,9,2,5,10], 3))
print(s.maxSumAfterPartitioning([1,4,1,5,7,3,6,1,9,9,3], 4))
print(s.maxSumAfterPartitioning([1], 1))