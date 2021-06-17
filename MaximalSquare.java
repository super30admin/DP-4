public class MaximalSquare {

    public int maximalSquareBF(char[][] matrix) {

        // Find 1
        // Move three directions(Bottom, right, diagonal) if we found 1 then it is valid
        // square
        // Increase the square count
        // Move diagnal and continue

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int sLength = helper(matrix, m, n, i, j);
                    result = Math.max(result, sLength);
                }
            }
        }
        return result * result;
    }

    private int helper(char[][] matrix, int m, int n, int i, int j) {
        int squareLength = 1;
        int iChange = i+1;
        int jChange = j+1;
        while (iChange >= 0 && iChange < m && jChange >= 0 && jChange < n) {

            // All Column
            for (int c = j; c <= squareLength; c++) {
                if (matrix[iChange][c] == '0') {
                    return squareLength;
                }
            }

            // All Rows
            for (int r = i; r <= squareLength; r++) {
                if (matrix[r][jChange] == '0') {
                    return squareLength;
                }
            }
            squareLength++;
            iChange++;
            jChange++;
        }
        return squareLength;
    }

    //TC: O(MN) - Iterating each cell
    //SC: O(MN) - For DP Matrix
    private int maximalSquare(char[][] matrix) {
         //Iterate each cell 
         //Logic - Start from the diagnal and check if the previous diagnal value is 1 or not.
         //If it is 1 then  Get the minimum of all three value(current, left and right) and put it in current diagnal
         //Fill all dp matrix and have max of result
         if(matrix == null || matrix[0].length == 0) return 0;
                int m = matrix.length;
                int n = matrix[0].length;
                int result = 0;
                int[][] dp = new int[m+1][n+1];
                for(int i=1;i<=m;i++) {
                    for(int j=1;j<=n;j++) {
                        if(matrix[i-1][j-1] == '1') {
                            int rowMin = Math.min(dp[i-1][j-1],dp[i-1][j]);
                            int value = Math.min(rowMin, dp[i][j-1]);
                            dp[i][j]= value+1;
                            result = Math.max(dp[i][j], result);
                        }
                    }
                }
                return result*result;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int result = new MaximalSquare().maximalSquare(matrix);
        System.out.println("The result is: " + result);
    }
}