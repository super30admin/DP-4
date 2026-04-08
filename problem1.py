# problem 1 

# https://leetcode.com/problems/maximal-square/description/

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp_arr = [[0]*(n+1) for _ in range(m+1)]
        max_val = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    dp_arr[i][j] = 1+min([dp_arr[i-1][j-1],dp_arr[i-1][j],dp_arr[i][j-1]])
                    max_val = max(max_val,dp_arr[i][j])
        return (max_val*max_val)