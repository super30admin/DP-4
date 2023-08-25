//Problem 1 - > Maximal Square
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        //dp matrix
        int[][] dp=new int[m+1][n+1];
        //Go over each cell
         for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //For every cell, take min of up, left and diagonal cell and add 1
                if(matrix[i-1][j-1]=='1'){//start calculating squares
                    int up=dp[i-1][j];
                    int left= dp[i][j-1];
                    int diag= dp[i-1][j-1];
                    dp[i][j]=1+Math.min(up, Math.min(left, diag));
                    max=Math.max(dp[i][j],max);
                }
            }
        }
         return max*max;
    }
}