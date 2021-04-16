//TC: O(m*n)
//SC: O(m*n) where m and n are the number of rows and columns of the input matrix

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        
        
        //create a dp matrix of size (m+1)x(n+1). Make the first row and column 0.
        int dp[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        
        int maxval = 0;
        
        //Check every diagonal element and see if this point is 1. If yes, then the value in the dp matrix will be the min of the immediately surrounding values + 1.
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    if(dp[i][j] > maxval){
                        maxval = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxval*maxval;
        
        
    }
};