//Time complexity: O(MN)
//Space complexity: O(MN)
//accepted on leetcode

class Solution {
    public int maximalSquare(char[][] matrix) {
        //return 0 if empty matrix
        if(matrix.length==0)
        {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //create a dp matrix with col and row more than the original matrix
        int[][]dp = new int [rows+1][cols+1];
        //initialise max length of resultant square
        int maxsqlen=0;
        //traverse over the matrix 
        for(int i=1; i<=rows;i++)
        {
            for(int j=1; j<=cols; j++)
            {
                //If value in matrix is 1
                if(matrix[i-1][j-1]=='1')
                {
                    //take the min of the adjacent 3 values and add 1 and store at i,j position of dp matrix
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    //update maxlength to the value stored at ij position in the dp matrix
                    maxsqlen = Math.max(maxsqlen,dp[i][j]);
                }
            }
        }
        //return the size of the square
        return maxsqlen*maxsqlen;
    }
}