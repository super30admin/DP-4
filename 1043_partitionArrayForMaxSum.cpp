// Time Complexity : O(N*K)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        if(arr.empty() || arr.size() == 0)
            return 0;
        int n = arr.size();
        vector<int> dp(n+1, 0);
        int m=0;
        for(int i=1; i<=n; i++){
            m = INT_MIN;
            for(int j=1; j<=k && i-j>=0; j++){
                m = max(m, arr[i-j]);
                dp[i] = max(dp[i], dp[i-j] + m * j);
            }
        }
        return dp[n];
    }
};
