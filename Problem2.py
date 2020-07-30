# Time Complexity : O(n^k)
# Space Complexity :O(n), for dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method 1) Using DP
class Solution:
    def maxSumAfterPartitioning(self, A, K):
        if len(A) == 0:
            return 0 
        dp = [0 for _ in range(len(A))]
        # dp[0] = A[0]
        
        for i in range(len(dp)):
            max_ = A[i]
            for j in range(1,K+1):
                if i-j+1 >= 0 and j <= K: 
                    max_ = max(max_, A[i-j+1])
                    if j <= i:
                        dp[i] = max(dp[i], dp[i-j] + (max_ * j))
                    else:
                        dp[i] = max(dp[i], max_ * j )
        
        return dp[-1]

if __name__ == "__main__":
    s = Solution()
    print(s.maxSumAfterPartitioning([1,15,7,9,2,5,10], 3))