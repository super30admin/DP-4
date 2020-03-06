//Time Complexity : O(N^2)
//Space Complexity : O(N^2)
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO


//Your code here along with comments explaining your approach
/*
we are gonna utilize DP to find square of maximum area.The intuition
behind this we are initalizing array with extra row and column.
We will maintain a global variable to find length of square
We starts looping through the maxtrix and looks for 1.Let this cell
be currentCell.Now find minimum value of down,next and diagonal cell 
to this currentCell and add 1 to it and memoize the value.
Compare memoized value with max value and update the value
Keep repeating the process until the matrix is traverese
*/
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
       
    if(matrix == null || row  == 0)
            return 0;
         int col = matrix[0].length;
        int dp[][] = new int[row + 1][col +  1];
int max = 0;
        for(int i =1; i < row; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max,dp[i][0] );
        }
        for(int i =0; i < col; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(dp[0][i] ,max);
        }
        
        for(int i =1; i < row; i++){
            for(int j =1; j < col; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j - 1],dp[i][j - 1]),dp[i - 1][j]) + 1;
                    max = Math.max(dp[i][j] ,max);
                }
            }
        }
        return max * max;
    }
}