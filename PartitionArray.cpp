class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        if(arr.empty()) return 0;

        int n = arr.size();

        vector<int> dp;
        dp[0] = arr[0];

        for (int i = 0; i < n; i++) {
            int currMax = 0;
            for (int j = 0; j <= k && i-j+1 >=0; j++) {
                currMax = max(currMax, arr[i-j+1]);
                if(i-j>=0)
                {
                    dp[i] = j*currMax + dp[i-j];
                }
                else
                {
                    dp[i] = j*currMax;
                }
            }        
        }
        return dp[n-1];
    }
};