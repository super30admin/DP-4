// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Populate a DP matrix when original array has element equal to 1, with the minimum value between top, left and top-left elements plus 1, which indicates that if all the elements are 1, then the maximum side of square will be 2.

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int curr = Character.getNumericValue(matrix[i][j]);
                if(curr == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = curr;
                    } else {
                        dp[i][j] = curr + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max*max;
    }
}
