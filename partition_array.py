# // Time Complexity :O((n*k)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach




class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0 for i in range(len(arr))]
        dp[0]=arr[0]
        for i in range(1,len(arr)):
                ma=dp[i]
                for j in range(1,k+1):
                    if i-j+1 >=0:
                        ma=max(ma,arr[i-j+1])
                        # print(ma)
                        if i-j>=0:
                            dp[i]=max(ma*j+dp[i-j],dp[i])
                            # print(dp)
                        else:
                            dp[i]=max(dp[i],ma*j)
        return dp[-1]
                    

                