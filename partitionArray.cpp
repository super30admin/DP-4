
/*

Intuition: Decision at a given partion, is dependent upon other paritions.
We have the choice of multiple paritions of size k.

Time Complexity: O(N*N)
Space Complexity: O(N)

*/

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int dp[arr.size()];
        for ( int i = 0; i < arr.size(); i++) dp[i] =0;
        dp[0] = arr[0];
        for ( int i = 1; i < arr.size(); i++){
            int maxEL = arr[i];
            for ( int j = 1; j <=k and i-j+1>=0; j++){
                maxEL = max( maxEL, arr[i-j+1]);
                if ( i-j >=0)
                    dp[i] = max(dp[i], maxEL* j + dp[i-j]);
                else
                    dp[i] = max(dp[i], maxEL* j );
            }
        
        }
        return dp[arr.size()-1];
        
    }
};