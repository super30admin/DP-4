// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//This can be solved using DP, we will create a dp matrix to store intermediate results
//We will start with calculating for square of size 1, then we will expand it for 2, 3 .. etc
//To find whether the next size is possible from the bottom right corner of that square
//We will check whether the left of it, top of it and diagonally previous to it are having some values
//If we take 1 + min of these 3 we will get the max possible square size

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSide = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    int side = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = side;
                    maxSide = Math.max(maxSide, side);
                }
                // else{   // This will be required if we want to reduce the space to O(n)
                //     dp[i][j] = 0;
                // }
            }
        }
        return maxSide * maxSide;
    }
}