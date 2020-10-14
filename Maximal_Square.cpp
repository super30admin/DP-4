// Time Complexity : O(m*n) traversing through the  dp matrix for all the values
// Space Complexity : O(m*n) for the dp matrix.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        // base condition
     if( matrix.size()== 0 || matrix[0].size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        
      
        
        vector<vector<int>> dp( m+1 , vector<int> (n+1)); 
        
        // setting first row & column to zero
        for( int i = 0; i <=n;i++){
            
         
            dp[0][i] = 0;
        }
        
         for( int i = 0; i <=m;i++){
          
            dp[i][0] = 0;
        }
        
        // result initialization
        int result = 0;
        
        // traversing on the whole dp matrix
        for (int i = 1; i <=m; i++){
            
            for( int j =1; j <=n; j++){
                
                if(matrix[i-1][j-1] == '1'){
                       
                // dp condition or calculation/.. this will be done only if the matrix value is 1.
                    dp[i][j] = min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1])) +1;
                    
                    // tracking the maximum value in martix
                    result = max(result,dp[i][j]);
                }else dp[i][j] = 0;
            }
        }
        return result*result;
        
        
        
    }
};