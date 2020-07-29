# brute force solution
# O((mn)^2) time complexity
# O(1) space complexity
# did this code run on leetcode? : yes
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n = len(matrix) # rows
        if n==0:
            return 0
        m = len(matrix[0]) # cols
        maxsize = 0
        
        # traverse every location in the matrix.
        for r in range(n):                                  # O(n)
            for c in range(m):                              # O(m)
                # check every element of the matrix.
                if matrix[r][c] != "1":
                    continue
                
                count = 1
                flag = True
                # traverse only if the corresponding elements (right neighbors) are 1s.
                # continue traversal to the right neighbors of current neighbors.
                while flag and (r+count) < n and (c+count) < m:     # O(mn)
                    # check the diagonal element
                    if matrix[r+count][c+count] != "1":
                        flag = False
                        break
                    # check elements in the row
                    for k in range(r+count-1, r-1, -1):
                        if matrix[k][c+count] != "1":
                            flag = False
                            break
                    # check elements in the column
                    for k in range(c+count-1, c-1, -1):
                        if matrix[r+count][k] != "1":
                            flag = False
                            break
                    if flag:
                        count += 1
                # find the maximum size square
                maxsize = max(maxsize, count)
        
        return maxsize**2




# using dynamic programming
# use the solutions solved at the beginning of the array to solve the remaining array.
# time compexity - O(mn)
# space complexity - O(1) without creating any extra matrix
# did this code run on leetcode? - yes
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        maxsize = 0
        # edge case
        if not matrix or len(matrix)==0:
            return 0
        
        # traverse the first row
        for c in range(len(matrix[0])):
            if matrix[0][c] == "1": 
                maxsize = 1 if maxsize==0 else 1
            matrix[0][c]=int(matrix[0][c])
            
        
        # traverse the first column.
        for r in range(len(matrix)):
            if matrix[r][0] == "1":
                maxsize = 1 if maxsize==0 else 1
            matrix[r][0]=int(matrix[r][0])
            
        # traverse the remaining arra
        for r in range(1, len(matrix)):
            for c in range(1, len(matrix[0])):
                if matrix[r][c] == "1": # use the previously solved problem to solve the current problem.
                    matrix[r][c] = min(matrix[r][c-1], matrix[r-1][c], matrix[r-1][c-1]) + 1 # check the constraining left neighboring value and increment it by 1.
                    maxsize = max(maxsize, matrix[r][c]) # find the maximum.
                else:
                    matrix[r][c]=0
        
        return maxsize**2
        