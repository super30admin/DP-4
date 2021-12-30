// Time Complexity : O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// bottom up approach to store the repeated sub problem and solve it by storing it in 1D array and 2 variables
// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int max = 0;
        int [] dp = new int [n+1];
        int prev = 0;
        int diff = 0;
        for( int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                prev = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], diff));
                    max = Math.max(max, dp[j]);
                }else{
                    dp[j] = 0;
                }
                diff = prev;
            }

        }
        return max * max;
    }
}

// // optimizing the repeted subproblems but having m*n space
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int [][] dp = new int[m+1][n+1];
//        int max = 0;
//        for( int i = 1; i < dp.length; i++){
//            for( int j = 1; j < dp[0].length; j++){
//                if(matrix[i-1][j-1] == '1'){
//                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
//                    max = Math.max(max, dp[i][j]);
//                }
//            }
//        }
//        return max * max;
//     }
// }

// exhasustive approach
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         if( matrix == null || m == 0) return 0;
//         int n = matrix[0].length;
//         boolean flag = false;
//         int max = 0;
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0; j < n; j++){
//                 if(matrix[i][j] == '1'){
//                     flag = true;
//                     int c = 1;
//                     while(i+c < m && j+c < n && flag){
//                         // check the column
//                         for( int k = j; k <= j+c; k++){
//                             if(matrix[i+c][k] == '0'){
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         for( int k = i; k <= i+c; k++){
//                             if(matrix[k][j+c] == '0'){
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         if(flag) c++;
//                     }
//                     max = Math.max(max,c);
//                 }
//             }
//         }
//         return max * max;
//     }
// }