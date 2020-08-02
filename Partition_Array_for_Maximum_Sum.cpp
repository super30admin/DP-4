// Time Complexity : O(N*K) where N=Number of elements in array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Dynamic Programming approach

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& A, int K) {
        
        if(A.size()==0){
            return 0;
        }
        int m=A.size();
        vector<int> dp(m,0);
        
        for(int i=0;i<m;i++){
            int mx = A[i];
            for(int j=1;i-j+1>=0 && j<=K;j++){
                mx = max(mx,A[i-j+1]);
                if(i>=j)
                    dp[i] = max(dp[i],dp[i-j]+mx*j);
                else{
                    dp[i] = max(dp[i],mx*j);
                }
            }    
        }
        return dp[m-1];
    }
};
