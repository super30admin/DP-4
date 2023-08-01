# Time Complexity : O(n*k)
# Space Complexity : O(n) to maintain the dp matrix

# The code ran on Leetcode

# Initialize a dp array. At every index, check for all partitions of size <= k and record the one that gives maximum sum. 

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*n; dp[0] = arr[0]
        for i in range(1, n):
            ma = arr[i]
            for j in range(1, k+1):
                if i - j + 1 >= 0:
                    ma = max(ma, arr[i-j+1])
                    if (i - j) >= 0:
                        dp[i] = max(dp[i], (j * ma) + dp[i-j])
                    else:
                        dp[i] = max(dp[i], j * ma)
        print(dp)
        return dp[-1]