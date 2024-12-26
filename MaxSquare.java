/*
 * tc - o(mn)
 * sc - (n)
 */

public class MaxSquare{
     //dp o(m*n) space o(n)
     public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n+1];
        int max = 0; 
        int diagUp = 0; //in 1d we need to just store this value, the others we can get from the dp array 
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    int tmp = dp[j];
                    dp[j] = 1 + Math.min(dp[j] , Math.min(diagUp, dp[j-1]));
                    max = Math.max(max, dp[j]);
                    diagUp = tmp;
                }else{
                    dp[j] = 0;
                }
            }
        }
        return max*max;
    }


    // //dp o(m*n)
    // public int maximalSquare(char[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int dp[][] = new int[m+1][n+1];
    //     int max = 0; 
    //     for(int i = 1; i <= m; i++){
    //         for(int j = 1; j <= n; j++){
    //             if(matrix[i-1][j-1] == '1'){
    //                 dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1], dp[i-1][j-1]));
    //                 max = Math.max(max, dp[i][j]);
    //             }
    //         }
    //     }
    //     return max*max;
    // }



    //brute force approach - m^2 n^2 
    // public int maximalSquare(char[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int max = 0;
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n ; j++){
    //             if(matrix[i][j] == '1'){
    //                 int le = 1; 
    //                 boolean flag= true;
    //                 while(flag && i + le < m && j + le < n){ // flag cause if at any point we have 0 so we need to break
    //                     //want to check around diagonal are 1s
    //                     for(int k = i + le; k >= i; k--){
    //                         if(matrix[k][j+le] == '0'){
    //                             flag = false;
    //                             break;
    //                         }
    //                     }
    //                     for(int k = j + le; k >= j; k--){
    //                         if(matrix[i+le][k] == '0'){
    //                             flag = false;
    //                             break;
    //                         }
    //                     }
    //                     if(flag) le++;
    //                 }
    //                 max = Math.max(max, le);
    //             }   
    //         }
    //     }
    //     return max*max;
    // }
}