#Time complexity: O(n*k)
#Space complexity: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0]*len(arr)
        dp[0]=arr[0]
        for i in range(1,len(arr)):
            maxi=arr[i]
            for j in range(i,i-k,-1):
                if(j>=0):
                    maxi=max(maxi,arr[j])
                    if j-1>=0:
                        dp[i]= max(dp[i],(i-j+1)*maxi + dp[j-1])
                    else:
                        dp[i]=max(dp[i],(i-j+1)*maxi)
        return dp[-1]
                    
                    
                    
                    
        