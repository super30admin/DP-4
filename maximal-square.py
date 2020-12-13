class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        col = len(matrix[0])
        row = len(matrix)
        #         flag=False
        #         area=0
        #         for i in range(row):
        #             for j in range(col):

        #                 if matrix[i][j]=='1':
        #                     curr=1
        #                     flag=True
        #                     while i+curr<len(matrix) and j+curr<len(matrix[0]) :

        #                         for k in range(i,i+curr+1):
        #                             if matrix[k][j+curr]=='0':
        #                                 flag=False
        #                                 break
        #                         # print(curr)
        #                         if not flag:
        #                             break
        #                         for k in range(j,j+curr+1):
        #                             if matrix[i+curr][k]=='0':
        #                                 flag=False
        #                                 break
        #                         if not flag:
        #                             break
        #                         curr+=1
        #                     area=max(area,curr)

        #         return area*area

        # time-O(m*n)**2 space=O(1)
        max_square_len = 0
        matrix1 = [[0 for i in range(col + 1)] for j in range(row + 1)]
        for i in range(1, len(matrix1)):
            for j in range(1, len(matrix1[0])):
                if matrix[i - 1][j - 1] == '1':
                    matrix1[i][j] = min(matrix1[i][j - 1], matrix1[i - 1][j], matrix1[i - 1][j - 1]) + 1
                    max_square_len = max(max_square_len, matrix1[i][j])

        return max_square_len ** 2
        # print(matrix1)
        # time=O(m*n) space-O(m*n)