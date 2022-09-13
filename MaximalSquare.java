//o(MN)
//o(MN) because of dp matrix
//can be solved without extra space;
class Solution {
    //dp solution
    public int maximalSquare(char[][] matrix) {
        //check the length 
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length ; int n = matrix[0].length;
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        //initiate a dp array
        int[][] dp = new int[m+1][n+1];
        // start at (1,1) in the matrix
        //becase all the values we calculate at 0th row and 0th column is same.
        //iterate over all the repeated sub problems we will get the result. just calculate the min value between all the values and add +1 to it.
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] =='1'){
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                    //update the max value
                    max = Math.max(max,dp[i][j]);
                }
        }
        
    }
        //max * max gives the square value
        return max*max;
    }
}
