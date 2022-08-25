"""
Runtime Complexity:
O(n*k) -  we dont keep a window of size and k and check the max in that. If we get max more than  currsum then we update it. We traverse over the list of size n. Therefore
overall runtime complexity is n*k.
Space Complexity:
O(n) - dp array of size n
Yes, the code worked on letcode.
Issues while coding -No
"""


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr or len(arr)==0:
            return 0
        n = len(arr)
        dp = [0 for i in range(n)]
        
        
        for i in range(0,n):
            max_ = arr[i]
            for j in range(1,k+1):
                if i-j+1>=0:
                    max_ =  max(max_,arr[i-j+1])
                    if i-j>=0:
                        currSum = (j*max_) + dp[i-j]
                    else:
                        currSum = (j*max_)+0
                    dp[i] = max(dp[i],currSum)
        return dp[i]