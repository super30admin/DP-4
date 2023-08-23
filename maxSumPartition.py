#TC - O(N*k)
#SC - O(k)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        def dfs(ind, arr, k,dp):
            n = len(arr)
            if ind == n:
                return 0
            if ind in dp:
                return dp[ind]
            length = 0 
            maxi = float("-inf")
            maxAns = float("-inf")
            for j in range(ind,min(ind+k,n)):
                length+=1
                maxi = max(maxi,arr[j])
                sumi = length*maxi + dfs(j+1,arr,k,dp)
                maxAns = max(maxAns,sumi)
            dp[ind] = maxAns 
            return dp[ind]
        dp = {}
        return dfs(0,arr,k,dp)