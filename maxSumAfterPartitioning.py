# Time Complexity :O(nk)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        dp =[0 for i in range(len(arr))]
        dp[0]=arr[0]
        for i in range (1,len(arr)):
            maxx=arr[i]
            for j in range(1,k+1):
                if(i-j+1>=0):
                    maxx=max(maxx,arr[i-j+1])
                    if(i-j>=0):
                        dp[i]=(max(dp[i],(j*maxx)+dp[i-j]))
                    else:
                        dp[i]=max(dp[i],j*maxx)
        return(dp[-1])
                

            
            
