//Brute Force

// Time Complexity : O(m^2n^2)
// Space Complexity : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    int sqLen = 1;
                    boolean flag = true;
                    
                    while(i+sqLen<m && j+sqLen<n && flag){
                        // check row
                        for(int k=j+sqLen; k>=j; k--){
                            if(matrix[i+sqLen][k] == '0')
                                flag = false;
                        }
                        
                        if(!flag) continue;
                        
                        // check col
                        for(int k=i+sqLen; k>=i; k--){
                            if(matrix[k][j+sqLen] == '0')
                                flag = false;
                        }
                        
                        if(flag) sqLen++;
                    }
                    max = sqLen>max? sqLen : max;
                }
            }
        }
        
        return max*max;
    }
}

//DP
//Time Complexity : O(mn)
//Space Complexity : O(mn)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) 
            return 0;
        
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }        
        return max*max;
    }
}