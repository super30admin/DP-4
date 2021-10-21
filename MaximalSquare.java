package DP4;

//Time complexity : O(n^2) as we are calculating min for each element
//Space complexity: O(n)
import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int currLeft = 0;
        int dp[] = new int[n+1];
        // int temp = new int[n+1];
        int prev = 0;
        int max = 0;
        int diagUp = 0;
        for(int i=1; i<=m;i++){
            for(int j=1; j<=n; j++){
                prev = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], diagUp));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = prev;
            }
        }
        return max*max;
    }
}
