/*
approach - Iteratvie
1. for current i, j  we check if the current grid has 1,
    
    a. we set area found till now is one. area =1 
    following is in my while loop
    b. then we check its diagonal element, if it's also 1, we check it and see if it's valid diagonal
    c. for a diagonal element to be valid, we check it's above rows for same column until i -- (i is our first element's i) and all of them should be one
            ame check for all the columns in same row till j, and all of them should be 1. 
    d. If this is the case - we add area++. 
    e. after we exhaust the while loop we set maxarea = max of (maxarea, area);
    
2.  we will keep doing it until we exhaust the for loop
TC - O(mn)^2 - as we traverse through the rows and cols for individual diagl=onal consider if all 1s in matrix.
sc - O(1) - no extra space. 
     

*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int max =0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i< m; i++)
        {
            for (int j=0; j< n; j++)
            {
                if(matrix[i][j] ==  '1')
                {
                    int area = 1;
                    boolean flag = true;
                    
                    while(i+area < m && j+area <n && flag)
                    {
                            int dir_i = i+area;
                            int dir_j = j+area;
                        
                            //traverse through all rows
                            for(int row = dir_i; row >= i; row--)
                            {
                                if(matrix[row][dir_j] == '0')
                                {
                                    flag = false;
                                    break;
                                }
                            }
                            
                            //traverse through all cols
                            for(int col = dir_j; flag && col >=j; col--)
                            {
                                if(matrix[dir_i][col] == '0')
                                {
                                    flag = false;
                                    break;
                                }
                            }
                        
                            //let say we never hit 0's 
                            if(flag)
                            {
                                area++;
                            }
                    }
                    
                    //set the max area
                    max = Math.max(max, area);
                }
            }
        }
        return max*max;
    
    }
}

//approach -2 
/*
approach - Optimized - DP solution
initals - we take one dp matrix of type int[][], and size will be m+1 and n+1 to avoid the boundary condition check. 
initialize max =0. 

1. in dp matrix we will start the for loop with i=1 and j=1. but for current charcter matrix, for the same grid we will check i-1, j-1. 
so for grid[0][0] in charcter matrix - that's the grid[1][1] in dp matrix. 

2. we will take the min of three neighbors of current grid , top-left-diagonal, left, top and will add 1 to it. 
3. we will only calculate the dp[i][j], if that corresponding grid has '1'. if zero, we will just place zero. 
4. once we update the grid in dp, we will also set the max = max of(max, dp[i][j])
5. at last we just return the max*max


Note - remeber we can not do this modification in place, as given is charcter matrix and once we do addition, that becomes a string!!

TC - O(m*n)+ 3(m*n) - traversal and checking for 3 neighobrs for total of mn elements.
sc - O(m*n) - dp matrix
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int max =0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        //int[][] dirs = {{-1,0}, {-1,-1}, {0,-1}}; //top, diagonal,left neighbor
        
        for(int i=1; i< m+1; i++)
        {
            for (int j=1; j< n+1; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] =  Math.min(dp[i-1][j],  Math.min(dp[i][j-1], dp[i-1][j-1])) +1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    
    }
}


//approach -3
//optimized DP on space
/*
approach-3 - space Optimized - DP solution
initals - we take one dp array of type int[], and size will be n+1 to avoid the boundary condition check. 
initialize max =0. 

before every j loop starts , we have diagonal reset to zero. 
1. arr[0] is the diagonal value and that's the extra col we added to avoid the boundary check. 
2. we are at i=0, j=0 in matrix , and we want to fill arr[j+1] = arr[1]
3. matrix[i][j] is 1;  then we calculate arr[j+1] 's value in temp  =min of [arr[j], arr[j+1], diagonal ] +1;
4. we change diagonal = arr[j+1], and arr[j+1] =temp
--- at setp -3 if we are standing at 0; we just update diagonal = arr[j+1], update arr[j+1]  =0 and move on. 

5. max = math.max(arr[j+1], max);
after we exhaust loop, 
6. at last we just return the max*max


Note - remeber we can not do this modification in place, as given is charcter matrix and once we do addition, that becomes a string!!

TC - O(m*n) traversal
sc - O(n) - dp array readuced from earlier approach of (O(mn))
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int max =0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n+1]; // by default will be zero!
        
        
        for(int i=0; i< m; i++)
        {
            int dig = 0;
            for (int j=0; j< n; j++)
            {
               if(matrix[i][j] == '1')
               {
                   int temp = Math.min(dig , Math.min(arr[j], arr[j+1])) + 1;
                   dig = arr[j+1];
                   arr[j+1] = temp;
                   max = Math.max(arr[j+1], max);
               }
                else
               {
                   dig = arr[j+1];
                   arr[j+1] = 0;
               }
            }
        }
        return max*max;
    
    }
}