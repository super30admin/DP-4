class Solution(object):
    def maximalSquare(self, matrix):
        globalmax=0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i-1>=0 and j-1>=0:
                    matrix[i][j]=(min(int(matrix[i-1][j]),int(matrix[i][j-1]),int(matrix[i-1][j-1]))+int(matrix[i][j]))*int(matrix[i][j])
                globalmax=max(globalmax,int(matrix[i][j]))       
        return globalmax**2