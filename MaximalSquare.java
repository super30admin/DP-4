// Bottom Up DP
// TC = O(MN)
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m+1][n+1];
//         int max = 0;
//         for(int i=1;i<=m;i++){
//             for(int j=1;j<=n;j++){
//                 if(matrix[i-1][j-1]=='1'){
//                     dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]));
//                     max = Math.max(max,dp[i][j]);
//                 }
//             }
//         }
        
//         return max*max;
//     }
// }

//Brute Force Solution
// TC = O(M^2*N^2) -- check once 
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++){ 
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    int l=1;
                    boolean flag = true;
                    while(i+l<m && j+l<n && flag){
                        for(int k=i+l;k>=i;k--){
                            if(matrix[k][j+l]=='0'){
                                flag = false;
                                break;
                            }
                        }

                        for(int k=j+l;k>=j;k--){
                            if(matrix[i+l][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) l++;
                    }
                    max = Math.max(max,l);
                }
            }
        }
        return max*max;
    }
}