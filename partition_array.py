class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """
        TC:O(k*len(arr))
        SC:O(len(arr))
        """
        if not arr:
            return 0
        dp=[0]*len(arr)
        dp[0]=arr[0]
        for i in range(1,len(dp)):
            maxx=arr[i]
            for j in range(1,k+1):
                if i-j+1>=0:
                    maxx=max(maxx, arr[i-j+1])
                    if i-j>=0:
                        dp[i]=max(dp[i],dp[i-j]+(maxx*j))
                    else:
                        dp[i]=max(dp[i],maxx*j)
        return dp[len(arr)-1]