/*
We can use Dynamic Programming to solve it , as we have overlapping sub problem
If we start from one point , we may have many squares that can be form , which kind of overlaps when we go to another point, (if we take into the account of number of squares can be formed from previous)

The technique is , at each point, if its '1', we will check Diagonal, up and left , that would make a (2x2) square, and a pont is a square in itself too
with dynamic programming , we will check in dp table , if any square exists in all valid dimentions, if so , then we will take min of that plus 1 (as a 1 can be a square in itself too)

Think of it as starting from one point and can go only in these dimentions to form a square
*/
class Solution {
    //Time: O(m*n), Space: O(m*n)
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int[][] dp = new int[m+1][n+1];

        int max = 0;

        for(int r =1;r<=m; r++){
            for(int c=1;c<=n;c++){
                if(matrix[r-1][c-1] == '1'){
                dp[r][c] = 1 + Math.min( dp[r][c-1], Math.min(dp[r-1][c] , dp[r-1][c-1]));
                max = Math.max(max, dp[r][c]);
                }
            }
        }

        return max * max; // area of a rectangle,  heaight * width , when going diagonal the height and width were same, so taking square of that       
    }

// Space optimized dp
//Time: O(m*n), Space: O(n)
    public int maximalSquareOp(char[][] matrix) {
        
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        int[] dp = new int[n+1];

        int max = 0;
        int prev =0;

        for(int r =1;r<=m; r++){
            for(int c=1;c<=n;c++){
               // if(c ==1) prev =dp;

                if(matrix[r-1][c-1] == '1'){

                dp[c] = 1 + Math.min( prev, Math.min(dp[c] , dp[c-1]));              
                max = Math.max(max, dp[c]);
                prev = dp[c];
                }
            }
        }

        return max * max; // area of a rectangle,  heaight * width , when going diagonal the height and width were same, so taking square of that      

    }
}