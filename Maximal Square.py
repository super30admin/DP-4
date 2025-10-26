'''
Solution 1: Brute Force
    - Iterate over the grid, when we find '1', start to form square from there.
    - W traverse diagonally and check if it's '1'. If YES, then
        - check if it's all '1's on bottom row of current probable sqaure
        - check if it's all '1's on rightmost col of current probable sqaure
        - If BOTH conditions satisfy, then we increase size of current sqaure. 
    - keep tracking max area = size*size
Time Complexity: O((m*n)^2) , m = total rows, n = total cols
Space Complexity: O(1)
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        maximum_square_area = 0
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j]=="1": # start searching for sqaure from here
                    diagonal_row = i
                    diagonal_col = j
                    size = 0
                    current_square_flag = True
                    while (diagonal_row<rows and diagonal_col<cols and matrix[diagonal_row][diagonal_col]=="1" and current_square_flag):
                        # Bottom row check on left of current diagonal for all 1's
                        for bottom_row_col in range(diagonal_col,j-1,-1):
                            if matrix[diagonal_row][bottom_row_col]=='0':
                                # sqaure breached
                                current_square_flag = False
                                break
                        
                        # check if flag is breached by bottom row check
                        if current_square_flag==False:
                            break
                        
                        # Right col check on Upper side of current diagonal cell for all 1's
                        for right_col_rows in range(diagonal_row,i-1,-1):
                            if matrix[right_col_rows][diagonal_col]=='0':
                                # sqaure breached
                                current_square_flag = False
                                break
                        
                        # check if flag is breached by Right col check
                        if current_square_flag==False:
                            break
                        
                        size+=1
                        diagonal_row+=1
                        diagonal_col+=1

                    maximum_square_area = max(maximum_square_area,size*size)

        return maximum_square_area  

'''
Solution 2: Dynamic Programming
    
Time Complexity: O(m*n) , m = total rows, n = total cols
Space Complexity: O(m*n)
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])

        dp_matrix = [[0]*cols for i in range(rows)]
        
        maximum_square_area = 0
        # fill up last row of DP_matirx with 1 if there is '1' in the grid 
        for j in range(0,cols):
            if matrix[rows-1][j]=='1':
                dp_matrix[rows-1][j] = 1
                maximum_square_area = 1 # square of size = 1 
        
        # fill up last col of DP_matirx with 1 if there is '1' in the grid 
        for i in range(0,rows):
            if matrix[i][cols-1]=='1':
                dp_matrix[i][cols-1] = 1
                maximum_square_area = 1 # square of size = 1
        
        for i in range(rows-2,-1,-1): # start from second last row
            for j in range(cols-2,-1,-1): # second last column
                if matrix[i][j]=='1':
                    # min(right, bottom,bottom_diagonal cell)
                    dp_matrix[i][j] = 1 + min(dp_matrix[i][j+1],dp_matrix[i+1][j],dp_matrix[i+1][j+1])
                    maximum_square_area = max(maximum_square_area,dp_matrix[i][j]*dp_matrix[i][j])
        
        return maximum_square_area

