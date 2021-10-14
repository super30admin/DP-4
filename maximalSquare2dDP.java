// O(m*n) for populating whole dp array
// O(m*n) dp array same as size of matrix array
// Idea here is to check the left top and diagonal element at each and according to previous solved
// subproblem decide if current cell is n*n square of 1s.
// if any of adjacent values have 0 then it is not a correct square.
// We keep track of largest square formed till now and at the end return largest.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int largest=0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i<matrix.length; i++) {
            dp[i][0]=0;
        }
        for(int j = 0; j<matrix[0].length; j++) {
            dp[0][j]=0;
        }
        for(int i=1; i<dp.length; i++) {
            for(int j = 1; j<dp[0].length; j++) {
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest*largest;
    }
}