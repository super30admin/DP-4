// //Brute force: top-down
// //TC = (m*n) for 1 element = O(m*n)^2 for entire matrix
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int max=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]=='1'){
//                     //square starts
//                     int l = 1;
//                     boolean flag = true;
//                     //falling on diagonals
//                     while(i+l < m && j+l < n && flag){
//                         //in same column check if everything is 1;
//                         for(int r = i+l; r>=i; r--){
//                             if(matrix[r][j+l] == '0'){
//                                 flag=false;
//                                 break;
//                             }
//                         }
//                         for(int c = j+l; c>=j; c--){
//                             if(matrix[i+l][c] == '0'){
//                                 flag=false;
//                                 break;
//                             }
//                         }
//                         if(flag) l++;
//                     }
//                     max = Math.max(max,l);
//                 }
//             }
//         }
//         return max*max;
//     }
// }

// //Repeated subproblems - hence DP
// //bottom-up
// //Time = O(m*n)
// //Space = O(m*n)
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int max = 0;
//         int [][] dp = new int[m+1][n+1];
//         for(int i=m-1; i>=0; i--){
//             for(int j=n-1; j>=0; j--){
//                 if(matrix[i][j] == '1'){
//                     dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
//                     max = Math.max(dp[i][j],max);
//                 }
//             }
//         }
//         return max*max;
//     }
// }

//Optimized space to O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n+1];
        for(int i=m-1; i>=0; i--){
            int diagDown = 0;
            for(int j=n-1; j>=0; j--){
                int temp = dp[j];
                if(matrix[i][j] == '1'){
                    dp[j] = 1 + Math.min(dp[j+1], Math.min(dp[j], diagDown));
                    max = Math.max(dp[j],max);
                } else {
                    dp[j] = 0;
                }
                diagDown = temp;
            }
        }
        return max*max;
    }
}

