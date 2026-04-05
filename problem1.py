"""
1. Top Down recursion
    a. We start from the top, initialize the cache with 0
    b. If we find a 1, we check the right, down and diagonal elements
    c. We can say we found a square if all the three elements are 1 so we use min of the three elements + 1 as the size
    d. We return the maximum of the cache values squared
    e. Time complexity: O(m*n)
    f. Space complexity: O(m*n)

2. Bottom up
    a. We start from the bottom, initialize the cache with 0
    b. If we find a 1, we check the left, up and diagonal elements
    c. We can say we found a square if all the three elements are 1 so we use min of the three elements + 1 as the size
    d. We return the maximum of the cache values squared
    e. Time complexity: O(m*n)
    f. Space complexity: O(m*n)
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

        if not matrix or len(matrix) == 0:
            return 0
        
        rows, cols = len(matrix), len(matrix[0])
        cache = {}

        #Approach 1: Top down recursion

        def helper(r, c):
            if r >= rows or c >= cols:
                return 0

            if (r,c) not in cache:
                right = helper(r, c+1)
                down = helper(r+1, c)
                diag = helper(r+1, c+1)

                cache[(r,c)] = 0

                if matrix[r][c] == "1":
                    cache[(r,c)] = 1 + min(right, down, diag)

            return cache[(r,c)]
        
        helper(0,0)

        return max(cache.values())**2

        #Approach 2: Bottom up Recursion

        def helper(r, c):
            if r < 0 or c < 0:
                return 0

            if (r,c) not in cache:
                left = helper(r, c-1)
                up = helper(r-1, c)
                diagleft = helper(r-1, c-1)

                cache[(r,c)] = 0

                if matrix[r][c] == "1":
                    cache[(r,c)] = 1 + min(left, up, diagleft)

            return cache[(r,c)]
        
        helper(rows-1,cols-1)

        return max(cache.values())**2  
        
    
