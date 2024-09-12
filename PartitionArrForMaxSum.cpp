// Approach - DP
// Time Complexity - O(n*k)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n);
        
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            int currMax = arr[i];
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                currMax = max(currMax, arr[i-j+1]);
                int curr = 0;
                if(i - j >= 0)
                    curr = j*currMax + dp[i-j];
                else
                    curr = j*currMax;
                dp[i] = max(dp[i], curr);
            }
        }
        return dp[n-1];
    }
};