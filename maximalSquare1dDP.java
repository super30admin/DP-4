// O(m*n) for populating whole dp array
// O(m*n) dp array same as size of matrix array
// Idea here is to check the left top and diagonal element at each and according to previous solved
// subproblem decide if current cell is n*n square of 1s.
// if any of adjacent values have 0 then it is not a correct square.
// We keep track of largest square formed till now and at the end return largest.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int largest=0;
        int[] dp = new int[matrix[0].length+1];
        int prev = 0;
        int diagUp = 0;
        for(int i=1; i<=matrix.length; i++) {
            for(int j = 1; j<=matrix[0].length; j++) {
                prev = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    // dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    dp[j] = 1+Math.min(dp[j-1], Math.min(dp[j], diagUp));
                    largest = Math.max(largest, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = prev;
            }
        }
        return largest*largest;
    }
}