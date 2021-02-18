# Time Complexity : O(N*K)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0 
        
        dp = [0]*len(arr)
        
        for i in range(len(dp)):
            mx = arr[i]
            
            for j in range(1, k+1):
                if i - j + 1 < 0:
                    break
                mx = max(mx, arr[i-j+1])
                if i -j >= 0:
                    dp[i] = max(dp[i], dp[i-j] + mx *j)
                else:
                    dp[i] = max(dp[i], mx * j)

        return dp[-1]