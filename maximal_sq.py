"""
Time : O(n*m)
Space: O(n*m)
Leet : Accepted
Problems : None
"""

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        memo = matrix[:]
        max_side = 0 #maintain max till now
        for row in range(len(memo)):
            for col in range(len(memo[0])):

                #find upper, left and diagonal upleft elements
                if row == 0:
                    up = 0
                else:
                    up = int(matrix[row-1][col])
                if col == 0:
                    left = 0
                else:
                    left = int(matrix[row][col-1])
                if row==0 and col ==0:
                    upleft = 0
                else:
                    upleft = int(matrix[row-1][col-1])

                if matrix[row][col] == '0':
                    #if zero enter zero
                    memo[row][col] == 0
                else:
                    #pick min of the three chosen elements and add 1 to it
                    memo[row][col] = min(up,left,upleft) + 1
                    if memo[row][col] > max_side:
                        max_side = memo[row][col]
        #return square
        return max_side ** 2
