# TC: O(N.k) where N is the length of the input array and k is the given partition length. 
# SC: O(N) for the dp array that we use to store the maximum sum till that index.

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr: 
            return 0
        
        dp = [-1]* len(arr)
        dp[0] = arr[0]
        
        for i in range(1, len(arr)):
            maxi = arr[i]
            for j in range(1, k + 1): 
                if i - j + 1 >= 0:
                    maxi = max(maxi, arr[i - j + 1])
                    if i - j >= 0: 
                        dp[i] = max(dp[i], maxi * j + dp[i - j])
                    else: 
                        dp[i] = max(dp[i], maxi * j)
        
        return dp[-1]
                      
