// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class PartitionArrMaxSum {

    public int maximalSquare(char[][] matrix) {
        
        // base case
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;

        // creating a dp matrix of size m+1 and n+1
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // If the char is 0, then set the value of the dp to 0 since no square can be formed at that position
                if(matrix[i-1][j-1] == '0'){
                    dp[i][j] = 0;
                    continue;
                }
                // If the char is 1, then fetch the minimum value from the neighbors left, diag-left-up & up.
                // Add 1 to the fetched minimum value which tells at current position what is the length of the square that can be formed.
                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;

                // Update the max length variable.
                max = Math.max(max, dp[i][j]);
            }
        }

        // Finally return the square of the length to calculate the size of the matrix.
        return max*max;
    }
    
}
