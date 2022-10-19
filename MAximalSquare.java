// Time Complexity : O(mn)
// Space Complexity :O(1)
// m is the number of rows in given matrix
// m is the number of columns in given matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//Approach 3 - Optimised without using extra dp matrix and modifying original matrix
//TC: O(mn)
//SC: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {

        //null check
        if(matrix == null ||  matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i = 0 ; i < m ; i++){
            if(matrix[i][0] == '1')
                max = 1;
        }

        for(int j = 0 ; j < n ; j++){
            if(matrix[0][j] == '1')
                max = 1;
        }

        for(int i = 1; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    int up = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int diagUp = matrix[i-1][j-1] -'0';
                    int curr = 1+ Math.min(up,Math.min(left,diagUp));
                    max = Math.max(max, curr);
                    matrix[i][j] = (char)(curr + '0');
                }
            }
        }
        return max*max;
    }
}

//Approach 2 - Optimised using extra dp matrix
//TC: O(mn)
//SC: O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {

        //null check
        if(matrix == null ||  matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

//Approach 1 - Brute Force
//TC: O(mn)^2
//SC: O(1)
// Gives TLE in leetcode
class Solution {
    public int maximalSquare(char[][] matrix) {

        //null check
        if(matrix == null ||  matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    boolean flag = true;
                    while(i+l < m && j+l < n && flag){
                        //check if column values are 1  
                        for(int k = i+l ; k >= i ; k--){
                            if(matrix[k][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        //check if all row values are 1
                        for(int k = j+l ; k >=j ; k--){
                            if(matrix[i+l][k] =='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            l++;
                    }
                    max = Math.max(max,l);
                }
            }
        }

        return max*max;
    }
}