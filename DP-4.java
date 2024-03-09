//1.Maximal Sqaures
//Time Complexity - > O(m*n)
//Space Complexity
class Solution {
    public int maximalSquare(char[][] matrix) {
        //optimized using DP
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1; j<=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
        
    }
}

//2nd Partition Array for Maximum Sum
class Solution {
    //go over it again
    //using DP as it has repeated sub problems
    //Time Complexity - > O(n*k)
    //space Complexity -> O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        for(int i = 1;i<n;i++){
           int currMax = arr[i];
           //here j is the number of partitions
           for(int j = 1; j<=k && i+1-j>=0;j++){
               currMax = Math.max(currMax, arr[i+1-j]);
               if(i-j>=0){
                   dp[i] = Math.max(dp[i],j*currMax + dp[i-j]);
               }else{
                   dp[i] = Math.max(dp[i],j*currMax);
               }
           }
        }

        return dp[n-1];
        
    }
}