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

# Time Complexity:o(mn)
# Space Complexity: o(mn)
# Approach:
# Approach is Dynamic Programming
# initialize the matrix with the same dimensions 
# dp(i, j)- represents the side length of the maximum square  
# starting from index(0,0) for every one we can update the value of the current element  dp[i][j] = 1 + min(dp[i - 1][j], min(dp[i][j-1], dp[i - 1][j - 1]))
# we traverse the original matrix once and find the maximum size. It gives the max length.
# Result is area so square the max length

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if(matrix == None or len(matrix) == 0):
            return 0
        m = len(matrix)
        n = len(matrix[0])if m > 0 else 0
        #  dp[][] = new [m + 1] [n + 1] in java
         # Initialize the dp table
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        maxLength = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if(matrix[i - 1][j - 1] == '1'):
                    dp[i][j] = 1 + min(dp[i - 1][j], min(dp[i][j-1], dp[i - 1][j - 1]))
                    maxLength = max(maxLength, dp[i][j])
        
        return maxLength * maxLength
        

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

# Time Complexity:o(n)
# Space Complexity: o(n)
# Approach:
# Approach is Bottom Up Dynamic Programming
# Initialize an array dp with all elements as 0 and  N as the length of the array.
#Iterate over the indices from N - 1 to 0 with start:
# the ending point as one of the next k indices by iterating over them with i.
# Store the maximum element as the variable maxi.
# Store the value dp[i] as max(dp[i], dp[i - j] + maxi * j).
# Return dp[n] after iterating over all elements.


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n + 1)

        for i in range(1, n + 1):
            maxi = -math.inf
            for j in range(1, min(i, k) + 1):
                maxi = max(maxi, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + maxi * j)

        return dp[n]
        