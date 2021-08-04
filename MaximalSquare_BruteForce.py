# TC: O(M x N)^2 as in worst case we traverse the entire matrix for every occurrence of 1. 
# SC: O(1) as we do not use any extra space.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix) == 0: 
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        max_len = 0
        
        for i in range(rows): 
            for j in range(cols): 
#                current diagonal length 
                if matrix[i][j] == "1": 
                    curr = 1
                    flag = True
                    while (i + curr) < rows and (j + curr) < cols and flag:
                        if matrix[i + curr][j + curr] == '0':
                            flag = False
                            break
                        for k in range(i, i + curr)[::-1]: 
                            if matrix[k][j + curr] == '0': 
                                flag = False
                                break
                        
                        for l in range(j, j + curr)[::-1]: 
                            if matrix[i + curr][l] == '0': 
                                flag = False
                                break
                        
                        if flag: 
                            curr += 1
                    max_len = max(max_len, curr)
        
        return max_len*max_len
