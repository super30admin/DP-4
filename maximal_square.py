#Time - O(m*n)
#Space - O(m*n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows,cols=len(matrix),len(matrix[0])
        
        cache={} #Storing the key value pair
        
        def helper(r,c):
            #base case
            if r>=rows or c>=cols:
                return 0
            
            #If not in cache then count the up, right and diag
            if (r,c) not in cache:
                down=helper(r+1,c)
                right=helper(r,c+1)
                diag=helper(r+1,c+1)
                
                #make the initial position of cache as 0
                cache[(r,c)]=0
                #If we find the one then take the min and add 1
                if matrix[r][c]=="1":
                    cache[(r,c)]=1+min(down,diag,right)
                
            return cache[(r,c)]
        
        helper(0,0)
        #Return the square if max value
        return max(cache.values())**2