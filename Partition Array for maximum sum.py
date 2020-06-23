#Time Complexity : O(n*k) where n is number of elemets and k is maximum value of subarray
#Sapce Complexity :  O(n) where n is number of elemets 
class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if len(A) ==None:
            return 0
        dp = [0 for x in range(len(A))]
        for i in range(len(dp)):
            max1  = 0
            for j in range(1,K+1):
                if (i -j+1 >=0):
                    max1 = max(max1,A[i-j+1])
                    if (i -j >= 0):
                        dp[i] = max(dp[i],(dp[i-j]+(max1*j)))
                    else:
                        dp[i] = max(dp[i], (max1*j))
        return dp[len(dp)-1] 
