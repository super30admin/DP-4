// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class MaximalSquare {

    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length ==0 ) return 0;//edge case check

            //get rows and cols
            int rows = matrix.length, cols = matrix[0].length;

            //create dp array
            int[][] dp = new int[rows+1][cols+1];

            int max=0;//value of max length row or col found
            //check row, col, and diagonal for 1's
            for (int i = 1; i <=rows; i++) {
                for (int j = 1; j <=cols; j++) {
                    if(matrix[i-1][j-1]=='1'){
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
            return max * max;
        }
    }
}
