/**
 * TC : O(n) SC : O(n)
 * Approach : traverse every cell and if you find 1 then check three directions that you already trvelled in the dp and change to the min 
 *            among them, while comparing the max with the current value. 
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++)
            {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    max= Math.max(max,dp[i][j]);
                }
            }   
        }
        // for(int i = 1; i < m; i++){
        //     System.out.println();
        //     for(int j = 1; j < n; j++)
        //     {
        //         System.out.print(dp[i][j]);        
        //     }
        // }
        return max*max;
    }
}