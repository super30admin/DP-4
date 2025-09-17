
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//we use dynamic programming to solve this problem as we have repeated subproblems
//we create a 2D dp array to store the maximum size of square sub-matrix ending at each cell    
//we iterate through the matrix and for each cell we check if it is '1' then we take the minimum of the 
// three adjacent cells (left, top, top-left) and add 1 to it.
// we also keep track of the maximum size of square sub-matrix found so far
//finally we return the area of the maximum square sub-matrix found
//we add 1 to the indices of dp array to avoid index out of bound exception

class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int dp[][]=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}