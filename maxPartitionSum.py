# TC: O(n*k)
# SC: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0]*(len(arr)+1)
        dp[1]=arr[0]
        for i in range(len(arr)):
            m=arr[i]
            if i==0:
                continue
            for j in range(i,i-k,-1):
                if j>=0:
                    m=max(m,arr[j])
                    dp[i+1]=max(dp[i+1], m*(i-j+1)+dp[j])
        return dp[-1]

