# Created by Aashish Adhikari at 8:32 PM 2/15/2021

'''
Time Complexity:
O(mn.mn)

Space Complexity:
O(1)
'''

class Solution(object):

    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """


        m = len(matrix)
        n = len(matrix[0])


        maxx = 0
        flag_1_exists = False

        for i in range(0, m):

            for j in range(0, n):

                if matrix[i][j] == "1":

                    # check diagonally upto where the square exists
                    flag_1_exists = True
                    curr = 1


                    while (i+curr < m and j+curr < n and flag_1_exists):

                        # we are at i+curr and j+curr

                        # check in the column
                        for k in range(i+curr, i-1, -1):

                            if matrix[k][j+curr] == "0":

                                flag_1_exists = False
                                break

                        # check in the row
                        for k in range(j+curr, j-1, -1):

                            if matrix[i + curr][k] == "0":

                                flag_1_exists = False
                                break


                        # If no 0 found in the row and column, continue diagonally
                        if flag_1_exists:
                            curr += 1
                    maxx = max(maxx, curr)
        return maxx * maxx






