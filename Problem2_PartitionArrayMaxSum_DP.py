'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 1043. Partition Array for Maximum Sum

# https://leetcode.com/problems/partition-array-for-maximum-sum/

#-----------------
# Time Complexity: 
#-----------------
# O( (K*N)) - Where K is the max length of partition and N is number of elements
#             in input array

#------------------
# Space Complexity: 
#------------------
# O(N): DP array of size N

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n)]
        
        dp[0] = arr[0]
        
        for i in range(1, n):
            max_val = arr[i]
            for j in range(1, k+1):
                max_val = max(max_val, arr[i-j+1])
                
                if i-j+1 >= 0:                
                    if i-j >= 0:
                        dp[i] = max(dp[i], (dp[i-j] + (j * max_val)) )

                    else:
                        dp[i] = max(dp[i], max_val * j)
                else:
                    break
        return dp[-1]
                        
                    
                        
                    