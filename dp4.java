//problem1
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        int maxi=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]));
                    maxi=Math.max(maxi,dp[i][j]);
                }
            }
        }
        return maxi*maxi;
    }
}
//problem2
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
         int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++) { 
            int currMax = 0;
            for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], currMax * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], currMax * j);
                }
            }
        }
        return dp[n - 1];
    }
}
