// TC : O(K*N)
// N - SIZE OF THE ARRAY
// SC : O(N)


class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n,0);
        dp[0] = arr[0];
        for(int i = 1; i<n;++i){
            int maxi = 0;
            for(int j=1; j<=k && i-j+1 >= 0 ; j++){
                int curr = arr[i-j+1];
                maxi = max(maxi,curr);
                if(i-j >= 0){
                    dp[i] = max(dp[i], maxi*j+dp[i-j]);
                }else{
                     dp[i] = max(dp[i], maxi*j);
                }
            }
        }
        return dp[n-1];
    }
};
