/*

Did it run on leetcode: yes
Did you face any issue: Yes


Time Complexity: O(N*M)
Space Complexity: 0(N*M)

Algorithm:
- we define our DP as the maximal size (square = size * size) of the square that can be formed till (i, j), denoted as dp[i][j]
- As sqaure is limited by (i-1,j) , (i,j-1) , (i-1,j-1) we say dp[i][j] = min[(i-1,j) , (i,j-1) , (i-1,j-1) ] +1



*/



class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        
        int[][] dp = new int[n][m];
        for(int i=0;i<m;++i){
            dp[0][i] = matrix[0][i]=='1' ? 1:0;
        }
        
        for(int j=0;j<n;++j){
            dp[j][0] = matrix[j][0]=='1' ? 1:0;
        }
        
        int maxSquare = 0;
        
        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    maxSquare = Math.max(maxSquare,dp[i][j]);
                }
            }
        }
        
        return maxSquare*maxSquare;
        
   
    }
}