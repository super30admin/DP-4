'''
Problem:  Partition Array for Maximum Sum
Time Complexity: O(k*n), where n is given elements and k is input
Space Complexity: O(n) for dp array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       at each element look for previous partitions and choose max sum
       we can look at previous k partitions only from 1 to k
       calculating maxele on the go for each partition
'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if len(arr)==0:
            return 0

        n = len(arr)
        dp = [0 for i in range(n)]
        dp[0] = arr[0]

        for i in range(1,n):
            maxele = arr[i]
            for j in range(1,k+1):
                if i-j+1>=0:
                    maxele = max(maxele, arr[i-j+1])
                    if i-j >=0:
                        dp[i] = max(dp[i], maxele * j + dp[i-j])
                    else:
                        dp[i] = max(dp[i], maxele * j)

        
        return dp[n-1]
