// Time Complexity:  O( m * n )
// Space Complexity: O( n )

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxS = 0;                                                   // maximum square length with all 1s
        int[] dp = new int[n+1];
        int prev = 0;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                
                if(matrix[i-1][j-1] == '1') {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(                              // maintaining dp array
                        prev, Math.min(
                            dp[j],
                            dp[j-1]
                        )
                    );
                    prev = temp;
                    maxS = Math.max(maxS, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
            }
        }
        return maxS * maxS;                                            // returning square of maximum square length
    }
}


// // ******************** Another mthod (2D array dp) ********************

// // Time Complexity:  O( m * n )
// // Space Complexity: O( m * n )

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int maxS = 0;                                                   // maximum square length with all 1s
//         int[][] dp = new int[m+1][n+1];
        
//         for(int i=1; i<=m; i++) {
//             for(int j=1; j<=n; j++) {
                
//                 if(matrix[i-1][j-1] == '1') {
//                     dp[i][j] = 1 + Math.min(                            // maintaining dp array
//                         dp[i-1][j-1], Math.min(
//                             dp[i-1][j],
//                             dp[i][j-1]
//                         )
//                     );
//                     maxS = Math.max(maxS, dp[i][j]);
//                 }
//             }
//         }
//         return maxS * maxS;                                             // returning square of maximum square length
//     }
// }


// // ******************** Another mthod (without dp) ********************

// Time Complexity:  O( m * n * (min(m,n))^2 )
// Space Complexity: O(1)

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int maxS = 0;                                                   // maximum square length with all 1s
        
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == '1') {
//                     int s = 1;
//                     int x = i;
//                     int y = j;
//                     while(x < m && y < n) {
//                         boolean valid = true;
//                         for(int r=i; r<=x; r++) {                       // check for last added column
//                             if(matrix[r][y] == '0') {
//                                 valid = false;
//                                 break;
//                             }
//                         }
//                         if(valid) {
//                             for(int c=j; c<=y; c++) {                   // check for last added row
//                                 if(matrix[x][c] == '0') {
//                                     valid = false;
//                                     break;
//                                 }
//                             }
//                         }
//                         if(valid) {                                     // if both are valid
//                             maxS = Math.max(maxS, s);                   // update maximum square length
//                             s++;
//                             x++;
//                             y++;
//                         }
//                         else {
//                             break;
//                         }
//                     }
//                 }
//             }
//         }
//         return maxS * maxS;                                             // returning square of maximum square length
//     }
// }
