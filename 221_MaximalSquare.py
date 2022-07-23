


class Solution:
    # Time Complexity: O(m^2*n^2)
    # Space Complexity: O(1)
    # go diagonal wise
    # when you at some point, you need to check it's row and col 
    # if both(row and col) having 1 then go to next diagonal element and 1 to length.
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or matrix == None:
            return 
        m = len(matrix) 
        n = len(matrix[0]) 
        maxx = 0
        l = 0
        for i in range(0,m):
            for j in range(0,n):
                if matrix[i][j] == "1":
                    l = 1
                    f = True
                    
                    while i+l < m and j+l < n and f:
                        # check col up cealing
                        k = i+l
                        while k >=i and f:
                           
                            if matrix[k][j+l] == "0":
                                f = False
                                break
                            k -=1
                        # check row 
                        k = j+l
                        while k >=j and f:
                            if matrix[i+l][k] == "0":
                                f = False
                                break
                            k -=1
                        if f:
                            l = l+1
                maxx = max(maxx,l)
        return maxx*maxx


    # Time Complexity: O(m*n)
    # Space Complexity: O(m*n)
    # only check three position :top left and top-left 
    # don't check whole row and col
    # we are doing this from [1,1], so we have these 3 elements.
    # check all 3 element, if there is 1(or greater) in all places then, square can be possible at that place ,
    # add 1 to there so whenever we are checking for it's neighbouring element we know that there is posible square
    # for ex, at [1,1] --> square is posible, so we will add 1 --> 1+1 = 2 -->it means square = 2*2 
    # now go to next element...max(top = 1,topleft = 1, left = 2) + 1 = 3
    # at the end we will return last element as l.
    def maximalSquare2(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or matrix == None:
            return 0
        m = len(matrix) 
        n = len(matrix[0]) 
        maxx = 0
        for j in range(0,n):
            if matrix[0][j] == "1":
                maxx = 1
        for i in range(0,m):
            if matrix[i][0] == "1":
                maxx = 1
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j] == "1":
                    
                    top = (int(matrix[i-1][j]))
                    topLeft = (int(matrix[i-1][j-1]))
                    
                    left = (int(matrix[i][j-1]))
                    temp = 1 + min(top,topLeft,left)
                    
                    maxx = max(maxx,temp)
                    print(maxx)
                    matrix[i][j] = chr(temp)
        return maxx*maxx                     
                            

    # Time Complexity: O(n*k)
    # Space Complexity: O(1)
    # dp solution
    def maximalSquare3(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or matrix == None:
            return 0
        m = len(matrix) 
        n = len(matrix[0]) 
        maxx = 0
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = 1 + min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])
                    maxx = max(dp[i][j], maxx)
                
        return maxx*maxx
                
                    
                    