// Time Complexity : O(m*n) traversing through the  dp matrix for all the values
// Space Complexity : O(n) for the dp vectors as we are using only 2 here. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        // base condition
     if( matrix.size()== 0 || matrix[0].size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        
      
      // instead of dp matrix using just 2 arrays   
        vector<int> dp( n+1,0); 
        vector<int> dp2( n+1,0); 
        

        // result initialization
        int result = 0;
        
        // traversing on the whole dp matrix
        for (int i = 1; i <=m; i++){
            
            for( int j =1; j <=n; j++){
                
                if(matrix[i-1][j-1] == '1'){
                       
                // dp condition or calculation/.. this will be done only if the matrix value is 1.
                    dp2[j] = min(dp2[j-1], min(dp[j], dp[j-1])) +1;
                    
                    // tracking the maximum value in martix
                    result = max(result,dp2[j]);
                }else dp2[j] = 0;
            }
            dp = dp2;
        }
        return result*result;
        
        
        
    }
};