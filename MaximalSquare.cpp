// Time Complexity : O(M*N) where N=Number of anagrams each having length K
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Dynamic Programming Approach

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        
        if(matrix.size()==0){
            return 0;
        }
        
        int m=matrix.size(),n=matrix[0].size();
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        int mx=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
               if(matrix[i-1][j-1]=='1'){
                   dp[i][j] = min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))+1;
                   mx = max(mx,dp[i][j]);
               }  
            }
        }
        return mx*mx;
    }
};
