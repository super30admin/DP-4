// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <vector>
#include <algorithm>
  
using namespace std;

class Solution {
public:
    int maxSumAfterPartitioning(std::vector<int>& arr, int k) {
        int n = arr.size();
        std::vector<int> dp(n + 1, 0);

        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                curMax = std::max(curMax, arr[i - j]);
                dp[i] = std::max(dp[i], dp[i - j] + curMax * j);
            }
        }

        return dp[n];
    }
};