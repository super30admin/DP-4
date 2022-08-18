// TC: O(m*n)
// SC: O(n)
  class Solution {
    public int maximalSquare(char[][] matrix) {
        
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int max = 0;
        // int[][] dp = new int[m+1][n+1];
        // for(int i=0;i<m;i++) {
        //     for(int j=0;j<n;j++) {
        //         if(matrix[i][j] == '1') {
        //             dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j])+1;
        //             max = Math.max(max, dp[i+1][j+1]);
        //         }
        //     }
        // }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n+1];
        int temp = 0;
        int prev = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == '1') {
                    prev =  dp[j];
                    dp[j+1] = Math.min(Math.min(dp[j], dp[j+1]), temp)+1;
                    max = Math.max(max, dp[j+1]);
                } else {
                    dp[j+1] = '0'; 
                }
            }
        }
        for(int i=0;i<n+1;i++) {
            System.out.print(dp[i]);
        }
        System.out.println();
        return max*max;
    }
}
