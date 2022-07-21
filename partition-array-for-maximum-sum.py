# Time Complexity: O(n*k)
# Space Complexity: O(n)
# Dp approach
# find all the possible partition at each point and find the max sum partition.
class Solution:
    def maxSumAfterPartitioning(self, nums: List[int], k: int) -> int:
        dp=[0]*len(nums)
        dp[0]=nums[0]
        for i in range(1,len(nums)):
            maxi=nums[i]
            for j in range(1,k+1):
                if i-j+1>=0:
                    maxi=max(maxi,nums[i-j+1])
                    if i-j>=0:
                        cur_sum=j*maxi+dp[i-j]
                    else:
                        cur_sum=j*maxi
                    dp[i]=max(dp[i],cur_sum)
        return dp[len(nums)-1]
            