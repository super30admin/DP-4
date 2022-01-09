# Time: O(m*n)
# Space: O(1)
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        ans = 0
        for i in range(len(matrix)):
            if matrix[i][0] == '1':
                ans = 1
        for i in range(len(matrix[0])):
            if matrix[0][i] == '1':
                ans = 1
        #print(matrix)
        for i in range(1, len(matrix)):
            for j in range(1,len(matrix[0])):
                #print(matrix[i-1][j], matrix[i-1][j-1], matrix[i][j-1])
                if int(matrix[i][j]) != 0:
                    matrix[i][j] = int(matrix[i][j]) + min(int(matrix[i-1][j]), min(int(matrix[i-1][j-1]), int(matrix[i][j-1])))
                    ans = max(ans, matrix[i][j]**2)
        #print(matrix)
        return ans
        
