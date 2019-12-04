'''
Leetcode - 1043 - Partition Array - https://leetcode.com/problems/partition-array-for-maximum-sum/
time complexity -O(N^2)
space complexity -O(N)
Approach - for every time we consider maximum value of k partitions and add to the previous sum

'''

class Solution(object):
    def maxSumAfterPartitioning(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        n=len(A)
        dp=[0]*(n)
        
        for i in range(len(dp)):
            max_ele=0
            for j in range(1,K+1):
                if i-j+1>=0:
                    max_ele=max(max_ele,A[i-j+1])
                    dp[i]=max(dp[i],((dp[i-j] if i>=j else 0) +max_ele*j))
        return dp[n-1]
                