# Created by Aashish Adhikari at 8:32 PM 2/15/2021

'''
Time Complexity:
O(m.n)

Space Complexity:
O(m.n)
'''

class Solution(object):

    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """


        m = len(matrix)
        n = len(matrix[0])

        dp = [[0. for idx in range(0,n+1)] for idxx in range(0,m+1)]
        # Notice the usage of m+1 and n+1 to fill the first row and first column with zeros
        maxx = 0

        # Logic : At each index, assume this index is the bottom-right of the square that can be formed.

        for i in range(1, m+1):                 # Notice that we are iterating over m+1 and n+1
            for j in range(1,n+1):

                if matrix[i-1][j-1] == "1": # Notice the usage of i-1 and j-1 as we are starting with 1 in dp array
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) # do it on board to see how this works

                    maxx = max(maxx, dp[i][j])



        return int(maxx * maxx)







