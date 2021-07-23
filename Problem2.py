# Time Complexity : O(n*k)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# considering bottom down and saving the maximum output to use further
# then iterating and checking the maximum considering k partitions from
# present action character
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        if arr == None or len(arr) == 0:
            return 0
        m = len(arr)
        dp = [0]*m
        
        dp[0] = arr[0]
        
        for i in range(1,len(dp)):
            maxi = arr[i]
            
            for j in range(1,k+1):
                
                if i - j + 1 >= 0:
                    maxi = max(maxi,arr[i-j+1])
                    if i-j >=0:
                        dp[i] = max(dp[i],dp[i-j] + maxi*j)
                    else:
                        dp[i] = max(dp[i],maxi*j)
                else:
                    break
        return dp[len(dp)-1]