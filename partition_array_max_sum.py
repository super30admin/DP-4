#Time complexity O(n*k)
#Space complexity O(n) for the dp array.
'''
We treat each case as the last element of our partition. For j between 0 and K,
we see that we can partition with the indices [i-j,j] (inclusive). The value if
we partitino like this is the max in that window times the size of that window.
Once we have that value, we add to whatever was the optimal partitions value
until index i-j-1. We do that for each k and keep the max as the value at that case.
We do that for each case. We also need to take care of the edge cases, when
i-j goes outside the window, and keep the max_val in that window.
'''


class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if  K>=len(A):
            return max(A)*len(A)
        if not A:
            return 0
        dp=[0]*len(A)
        for i in range(len(dp)):
            max_val=0
            for j in range(K):
                if i-j<0: break
                if i-j-1>=0:
                    #get the max from the new window
                    max_val=max(max_val,A[i-j])
                    #add the optimal value for after that window
                    dp[i]=max(dp[i-j-1]+max_val*(j+1),dp[i])

                else:
                    max_val=max(max_val,A[i-j])
                    dp[i]=max(max_val*(j+1),dp[i])
        return dp[-1]
