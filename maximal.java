// Time Complexity : o(NxM)
// Space Complexity :o(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : nO

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of cols
        int[] dp = new int[n + 1]; // initialising the array with 1 + cols size
        int max = 0;
        for (int i = 1; i < m + 1; i++) { // iterating from 1
            int temp = dp[0]; // setting the temp to 0 and in the first index the top and to the left element is undefined/out of bound/ 0
            for (int j = 1; j < n + 1; j++) { // iterating from 1 and in the dp array, we kept first element as 0
                int prev = dp[j]; // setting current value of prev, will be helpful in setting the temp value
                if (matrix[i - 1][j - 1] == '1') { // if found 1
                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(dp[j], temp)); //1 + minimum of up, left, and up and to the left (temp)
                    max = Math.max(max, dp[j]); // maximum square so far
                } else {
                    dp[j] = 0; // found 0 so set dp array value to 0
                }
                temp = prev; // temp value
            }
        }
        return max * max; // area s*s -> largest square = consecutive diagonal 1's found with condition to be true 
    }
}