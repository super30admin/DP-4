# // Time Complexity : O(nk)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# repeated subproblem hence we use DP
# use 1D dp array
# move i in array and for each i we calculate maximum value we can get
# using window of length 1 to k


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
    
        dp = [0]*len(arr)
        dp[0] = arr[0]
        for i in range(1,len(arr)):
            maximum = arr[i]
            j = 1
            while i-j+1 >=0 and j<=k:
                maximum = max(maximum, arr[i-j+1])
                if i-j>=0:
                    dp[i] = max(dp[i],dp[i-j] + maximum*j)
                else:
                    dp[i] = max(dp[i],maximum*j)
                j += 1
                
        return dp[len(arr)-1]
         