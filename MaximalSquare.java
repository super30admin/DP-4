// Time Complexity : O(m^2 * n^2) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Increase diagonally and check if the rows and column does not contain 0

// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(matrix[i][j] == '1'){
                    boolean flag = true;
                    int l = 1; // to increase the size of square diagonally

                    while(i+l < m && j+l < n && flag){
                        //row check 
                        for(int k = i+l ; k >= i ; k--){
                            if(matrix[k][j+l] != '1'){
                                flag = false;
                                break;
                            }
                        }
                        //column check
                        for(int k = j+l ; k >= j ; k--){
                            if(matrix[i+l][k] != '1'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            l++; // increase the length of square
                        }
                    }
                    max = Math.max(max,l);
                }
            }
        }

        return max * max;
    }
}

//DP - We are moving top to bottom
// Time Complexity : O(mn) 
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;

        for(int i = 1; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){

                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                    
                    max = Math.max(max,dp[i][j]);
                }
            }
        }

        return max * max;
    }
}

// O(n) space

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int max = 0;

        for(int i = 1; i <= m ; i++){
            int diagUp = 0;
            for(int j = 1 ; j <= n ; j++){
                int temp = dp[j]; // this will act as our diagup for next element
                if(matrix[i-1][j-1] == '1'){
                                            //Up, left, diagUp
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1],diagUp));
                    
                    max = Math.max(max,dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }

        return max * max;
    }
}