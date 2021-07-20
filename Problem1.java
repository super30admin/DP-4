
// Time - O(M*N)
// Space - O(M*N)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [][] dp = new int[m+1][n+1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {

                if(matrix[i-1][j-1] == '1') { // original matrix if we found 1

                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1])) + 1;  // calculate the min on the top, left and diagonal
                    max = Math.max(max,dp[i][j]); // return the max element

                }

            }

        }

        return max*max;

    }
}



// Time - O(M*N)
// Space - O(N)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n+1];
        int prev = 0; // declaring the previous val
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(matrix[i-1][j-1] == '1') { // original matrix if we found 1

                    int temp = dp[j]; //store the element that will change in the temporary variable

                    dp[j] = Math.min(dp[j-1], Math.min(dp[j],prev)) + 1;  // calculate the min on the top, left and diagonal
                    prev = temp; //assign the temp value to prev

                }
                else {
                    dp[j] = 0; // case when character is 0
                }
                max = Math.max(max,dp[j]); // return the max element
            }

        }

        return max*max;

    }
}