'''
Problem:  Maximal Square
Time Complexity: O(M * N), where M is rows and N is cols
Space Complexity: O(M * N), for dp array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       Applied bottom up DP
       checking previous squares while calculating valid squares for current element
'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxside = 0

        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i][j-1], min(dp[i-1][j-1], dp[i-1][j]))
                    maxside = max(maxside, dp[i][j])


        return maxside * maxside