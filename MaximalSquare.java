// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use dynamic programming to store the size of the largest square ending at each cell.
//   - Maintain a 1D dp array of length (n+1), where n is the number of columns.
//   - Update dp[j] using the minimum of three values: dp[j] (top), dp[j-1] (left), and diagUp (top-left).
//   - Use a temp variable to track the top-left value (diagUp) before it is overwritten.
//   - Keep track of the maximum square size encountered.

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //dp, optimal solution - TC = O(mxn), SC = O(n)
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int[] dp = new int [n+1];

        int diagUp = 0;
        //we can go top left to bottom right or in opposite direction.
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    max = Math.max(max, dp[j]);
                }
                diagUp = temp;
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int result = obj.maximalSquare(matrix);
        System.out.println("Maximal square area: " + result); // Expected: 4
    }
}
