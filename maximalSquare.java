//Time : O(m*n) m and n are the length and breath of the matrix
//Space: O(m*n)
//Leetcode : worked - but the run time is very high can you please check it in your pc and let me know what is the problem

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n+1][m+1];
        int max = 0;
        for(int i =1;i<=n;i++){
            for(int j = 1;j <=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) +1;
                    max = Math.max(max,dp[i][j]);
                    
                }
                System.out.println(dp[i][j]);
                                    
            }
        }
        
        return max*max;
    }
}