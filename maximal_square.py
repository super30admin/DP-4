#Time Complexity O(n*m), n rows, m columns
#Space complexity O(1), no extra space

'''
Each case represent max possible square side formed with that case as the bottom
left corner. It's easy to visualize that the square formed from the left case,
diagonal left case and upper case together with the present square form another 
square of length min(squares)+1. Simply put, the left case takes care of the
left row, upper case the column and diagonal case the diagonal element of the 
new square. So we can calculate th value for each case as min(left,up,diagonal_left)+1
'''




class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        max_side=0
        for i in range(len(matrix[0])):
            max_side=max(max_side,int(matrix[0][i]))
        for i in range(len(matrix)):
            max_side=max(max_side,int(matrix[i][0]))
            
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[0])):
                if matrix[i][j]=='1':
                    matrix[i][j]=str(min(int(matrix[i-1][j]),int(matrix[i][j-1]),int(matrix[i-1][j-1]))+1)
                    max_side=max(int(matrix[i][j]),max_side)
        return max_side**2
