//time: O(n*k) space: O(n)
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n+1, 0);
        for(int i = n-1; i >= 0; i--) {
            int maxEle = INT_MIN;
            for(int x = 1; x <= k && (i+x) <= n; x++) {
                maxEle = max(maxEle, arr[i+x-1]);
                dp[i] = max(dp[i], maxEle*x + dp[i+x]);
            }
        }
        return dp[0];
    }
};

