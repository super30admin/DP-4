//time complexity:O(m*k)
//space complexity:O(m)
//executed on leetcode: yes
//approach:using dp
//any issues faced? yes, had to see the solution

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int len = arr.size();
        int dp[len+1];
        memset(dp,0,sizeof(dp));
        for(int i = 1; i <= len; i++) {
            int maxi = arr[i - 1];
            for(int j = 1; j <= k; j++) {
                if(i >= j) {
                    maxi = max(maxi, arr[i-j]);
                    dp[i] = max(dp[i], dp[i - j] + j * maxi);
                }
            }
        }
        return dp[len];
    }
};