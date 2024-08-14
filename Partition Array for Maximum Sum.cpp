//time: O(n*k)
//space: O(n)
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

        //from sols - apparently uses O(k) space

        // int N = arr.size();
        // int K = k + 1;

        // int dp[k + 1];
        // memset(dp, 0, sizeof(dp));

        // for (int start = N - 1; start >= 0; start--) {
        //     int currMax = 0;
        //     int end = min(N, start + k);
            
        //     for (int i = start; i < end; i++) {
        //         currMax = max(currMax, arr[i]);
        //         dp[start % K] = max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
        //     }
        // }
        // return dp[0];
    }
};


