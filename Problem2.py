'''

Time Complexity : O(nk)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Create a DP cache to store the maximum sums possible and go on calcualting the possible max sub-array which can be formed

'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0] * k
        dp[0] = arr[0]

        for i in range(1,len(arr)):
            curmax = 0
            maxsum = 0
            for j in range(i,i-k,-1):
                if j < 0 :
                    break
                curmax = max(curmax,arr[j])
                cursum = curmax * (i-j+1)
                prevsum = dp[(j-1)%k] if j-1 >= 0 else 0
                maxsum = max(maxsum,prevsum+cursum)

            dp[i%k] = maxsum

        return dp[(len(arr)-1)%k]
