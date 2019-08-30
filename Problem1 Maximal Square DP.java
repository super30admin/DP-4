// TC : O(rows*cols)
// SC : O(row+1, cols+1) matrix

//IDEA : Add the minimum of up left and diagoanl left up valuse to curretn i + 1  in the DP array 
// Traverse the whole dp array and calculate the lenght of the square can be formend.
// return maxlength * maxlength

//LC Run : Success.


class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        
        int [][] dp = new int[rows+1][cols+1];
        int max =0;
        
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1] == '1')
                dp[i][j] =Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                System.out.print(dp[i][j]+" ");
                max = Math.max(max,dp[i][j]);
            }
            System.out.print("\n ");
        }
        
        return max*max;
        
    }
}
