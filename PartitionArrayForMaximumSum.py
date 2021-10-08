"""
Time Complexity : O(n x k) where n is the length of the array and k is th eno. of partitions
Space Complexity : O(n) where n is the length of the array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        if arr == None or len(arr) == 0:
            return 0
        m = len(arr)
        dp = [0]*m

        dp[0] = arr[0]
         # considering bottom down and we save the maxi output to use the computation 
         # further. We then iterate and check the maxx while looking at the k value
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