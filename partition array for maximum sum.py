# TC:O(n*k)
# SC:O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n=len(arr)
        dp=[-1]*n


        def dfs(ind,k):
            if ind==len(arr):
                return 0

            if dp[ind]!=-1:
                return dp[ind]
            
            max1,max_sum,length=0,0,0

            for i in range(ind,min(ind+k,n)):
                length+=1
                max1=max(max1,arr[i])
                cur_sum=length*max1+dfs(i+1,k)
                max_sum=max(cur_sum,max_sum)
            dp[ind]=max_sum

            return dp[ind]

        return dfs(0,k)