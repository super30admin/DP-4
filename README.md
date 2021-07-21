# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
//DP Approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0; 
        int max = 0; 
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1; 
                    max = Math.max(max, dp[i][j]); 
                }
            }
        }
        return max * max; 
    }
}

## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0; 
        int max = 0;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i = 1; i < dp.length; i++){
            max = arr[i];
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                max = Math.max(max, arr[i - j + 1]);
                if(i - j >= 0){
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                }else{
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[arr.length - 1]; 
    }
}

