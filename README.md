# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4
# Time Complexity = O(nm)
# Space Complexity = O(n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        maxval=0
        dp=[0 for _ in range(n+1)]
        a=0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='1':
                    k=dp[j]
                    dp[j]=min(dp[j],dp[j-1],a)+1
                    a=k
                    
                else:
                    dp[j]=0
                maxval=max(maxval,dp[j])
        
        return maxval*maxval
## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.

Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3

Output: 84

    Explanation: A becomes [15,15,15,9,10,10,10]

Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6
# Time Complexity = O(nk)
# Space Complexity = O(n)


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0 for _ in range(len(arr))]
        dp[0]=arr[0]
        for i in range(1,len(arr)):
            m=arr[i]
            for partition in range(1,k+1):
                if i-partition<0:
                    dp[i]=max(dp[i],partition*m)
                    break
                dp[i]=max(dp[i-partition]+partition*m,dp[i])
                m=max(m,arr[i-partition])
        return dp[len(arr)-1]
        