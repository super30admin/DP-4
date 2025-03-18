// Problem1:(https://leetcode.com/problems/maximal-square/)

// Time Complexity : O(mxn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start from the bottom and find the maximum square that can be formed is the element is 1, check for min among right, down and diagonal
 * down and add 1 to it. Do till the top and find max for every element filling. Finally return max*max.
 */
// 1
class Solution {
    public int maximalSquare(char[][] matrix) {
     int m = matrix.length;
     int n = matrix[0].length;
     int max = 0;
     for(int i = 0; i< m; i++){
        for(int j = 0; j < n; j++){
            if(matrix[i][j] == '1'){
                int l = 1;
                boolean flag = true;
                while(flag && i+l<m && j+l < n){
                    // same col towards top
                    for(int a = i+l;a>=i;a--){
                        if(matrix[a][j+1] == '0'){
                            flag = false;
                            break;
                        }
                    }
                    // same row towards left
                    for(int b = j+l;b>=j;b--){
                        if(matrix[i+l][b] == '0'){
                            flag = false;
                        }
                    }
                    if(flag){
                        l++;
                    }
                }
                max = Math.max(max, l);
            }
        }
     } 
     return max*max;  
    }
}
// 2
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp = new int[m+1][n+1];
        int max = 0;
        for(int i = m-1; i>=0;i--){
            for(int j = n-1; j>=0; j--){
                if(matrix[i][j]=='1'){
                    dp[i][j] = 1+Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max*max;  
    }
}
// 3
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int []dp = new int[n+1];
        int max = 0;
        for(int i = m-1; i>=0;i--){
            int diagonal = 0;
            for(int j = n-1; j>=0; j--){
                int temp = dp[j];
                if(matrix[i][j]=='1'){
                    dp[j] = 1+Math.min(dp[j+1], Math.min(dp[j], diagonal));
                    max = Math.max(max, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                diagonal = temp;
            }
        }
        
        return max*max;  
    }
}