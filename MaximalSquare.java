// Time Complexity : O((mn)^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//brute force
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 ) return 0;
        int m  = matrix.length;
        int n = matrix[0].length;
        int max =0;
        for(int i=0;i< m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    int l =1;
                    boolean flag = true;

                    while(flag && i+l <m && j+l <n){
                        //check all the rows till i
                        for(int k =i+l;k>=i;k--){
                            if(matrix[k][j+l]=='0'){
                                flag = false;
                                break;
                            }
                        }

                        //check for all columns till j
                        for(int k =j+l;k>=j;k--){
                            if(matrix[i+l][k]=='0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            l++;
                        }
                    }
                    max = Math.max(max,l);
                }
            }
        }
        return max * max;
    }
}

// using dp
// TC: O(mn)
//SC: O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 ) return 0;
        int m  = matrix.length;
        int n = matrix[0].length;
        int max =0;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j]= 1+ Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}

//DP with space optimization
//TC= O(mn)
//SC= O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 ) return 0;
        int m  = matrix.length;
        int n = matrix[0].length;
        int max =0;
        int[] dp = new int[n+1];

        for(int i=1;i<=m;i++){
            int diagup=0;
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    int temp = dp[j];
                    dp[j]= 1+ Math.min(dp[j], Math.min(diagup, dp[j-1]));
                    max = Math.max(max, dp[j]);
                    diagup = temp;
                }else{
                    dp[j] = 0;
                }
            }
        }
        return max * max;
    }
}