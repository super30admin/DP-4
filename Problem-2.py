#Approach
#Explore all the k partitions and store the result of each partition if the greater then update max


#Complexities:
#Time : O(N)
#Space : O(N)



from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        n = len(arr)
        dp = [0 for _ in range(n+1)]


        for i in range(1, n+1):

            for part in range(k):
                if i-1 - part >= 0:
                    result = max(arr[i - part-1:i]) * (part+1) + dp[i-1 - part]


                    dp[i] = max(dp[i], result)

        return dp[n ]

s = Solution()
print(s.maxSumAfterPartitioning([3,7],2))
print(s.maxSumAfterPartitioning([1,15,7,9,2,5,10],3))