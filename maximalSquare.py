class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        '''
        Time, Space Complexity: O(mn)
        '''
        x = [[0 for j in range(0,len(matrix[0])+1)] for i in range(0,len(matrix)+1)]
        max=0
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                if(matrix[i][j]=="1"):
                    # we store the minimum length of square of all 1 using dp
                    x[i+1][j+1] = min(x[i][j],x[i+1][j],x[i][j+1])+1
                    if(x[i+1][j+1]>max):
                        max = x[i+1][j+1]
        
        return max*max
