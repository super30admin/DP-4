# DP Solution 
# TC: O(n*k)
# SC: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        n = len(arr)
        dp = [0 for _ in range(n)]
        dp[0] = arr[0]
        
        for i in range(1,n):
            maxi = arr[i]
            for j in range(1,k+1): # Upto j = k
                if i-j+1 < 0:
                    break
                maxi = max(maxi,arr[i-j+1])
                curr_partition = maxi*j
                if i-j >= 0:
                    curr_partition = maxi*j + dp[i-j]
                    
                dp[i] = max(dp[i],curr_partition)
        return dp[n-1]