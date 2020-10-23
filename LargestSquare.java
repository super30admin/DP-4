/*
 * #221. Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

 */


/*
 * Time Complexity: O (m*n) -> To traverse through DP matrix of 'n+1' rows and 'm+1' columns
 * 
 * Space Complexity: O (m*n) -> Creating a DP matrix of 'n+1' rows and 'm+1' columns, one extra row and column than input matrix
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP4;

public class LargestSquare {
	public int maximalSquare(char[][] matrix) {
        
        // #1. Base condition
        // If no matrix is given, largest square we can have is 0, so area = 0, return 0
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        // #2. Get the number of rows and columns in a variable
        int n = matrix.length;
        int m = matrix[0].length;
        
        // #3. Create a DP matrix with rows = n+1 and column = m+1, one extra row and column than input matrix
        // The extra row and column will have dummy values filled with 0
        int[][] dp = new int[n+1][m+1];
        
        // #4. Initialize max to negative infinity
        int maxSquare = Integer.MIN_VALUE;
        
        // #5. Start processing DP matrix from row = 1 and column = 1
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // We will compute optimal answer at a point only if character in input matrix is '1', else won't do anything, since DP matrix will be initialized with 0's. leave the value as 0 at that point
                 // We can access the character from input matrix with matrix[i-1][j-1] because of an extra row and column in DP matrix
                if(matrix[i-1][j-1] == '1'){
                    // 1 + minimum from 3 directions -> left, left's top and left's top.right
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                    
                    // Update the maxSquare if value at a current point is greater than previous maxSquare
                    // maxSquare will be the side of a largest square found in an input matrix
                    // The reason we are keeping track of maxSquare is we won't find our answer at last (row,column) unlike other DP problems
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                    
                }
            }
        }
        
        // Area of a sqaure = side * side -> maxSquare is a side of largest square found in input matrix
        return maxSquare * maxSquare;
    
        
    }

}
