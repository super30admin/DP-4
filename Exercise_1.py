#Time Complexity : O(M*N), M and N begin the length and widths of array
#Space Complexity : O(1), because using the same given array
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to review solution to figure out a strategy.
'''Traverse the matrix. At each point, check if the left, top, and upper-left values are all 
greater than 0. If so, take the minimum and add by 1, for the value at the point. Keep track
of maximum of points. 
'''
class Solution:
    def __init__(self):
        self.result = 0
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        #define left, top, and upper-left values
        directions = [[-1,0],[0,-1],[-1,-1]]
        for i in range(rows):
            for j in range(cols):
                # if point is greater than 0, then find if left, top, and upper-left vales. 
                if int(matrix[i][j])>0:
                    points= []
                    for d in directions:
                        if i+d[0]>=0 and i+d[0]<rows and j+d[1]>=0 and j+d[1]<cols:
                            point = int(matrix[i+d[0]][j+d[1]])
                            points.append(point)
                    # if all 3 points are greater than 0, find the minimum and add by 1 
                    if len(points)==3:
                        matrix[i][j] = str(min(points)+1)
                    # keep track of maximum value
                    if int(matrix[i][j])>self.result:
                        self.result=int(matrix[i][j])
        #return the square of maximum. 
        return self.result*self.result
                    
