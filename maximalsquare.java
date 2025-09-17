//TC: O(m·n) — single pass over all cells.
//SC: O(n) — 1D DP array plus O(1) temps.

//Let dp[j] be the side length of the largest all-'1' square ending at current row, column j-1; keep diagUp as the previous row’s dp[j-1] (top-left).
//For each cell (i-1, j-1): if it’s '1', set dp[j] = 1 + min(dp[j] /*up*/, dp[j-1] /*left*/, diagUp /*top-left*/); else dp[j] = 0; update max.
//Use temp = dp[j] before overwriting to advance diagUp = temp as you sweep left→right; return max*max (area).

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int[] dp = new int[n+1];

        int diagUp = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }  

        return max * max;   
    }
}
