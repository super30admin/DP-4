// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Partition Array for Maximum Sum
// Approach: Dynamic Programming
// Time Complexity: O(N * K)
// Space Complexity: O(N)

class Solution {
    public:
        int maxSumAfterPartitioning(vector<int>& arr, int k) {
            if (arr.empty() || k == 0) {
                return 0;
            }
    
            int n = arr.size();
            vector<int> dp(n, 0);
            dp[0] = arr[0];  
    
            for (int i = 1; i < n; i++) {
                int maxVal = arr[i];
                for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                    maxVal = max(maxVal, arr[i - j + 1]);  
                    if (i - j >= 0) {
                        dp[i] = max(dp[i], dp[i - j] + j * maxVal);  
                    }
                    else {
                        dp[i] = max(dp[i], j * maxVal);  
                    }    
                }
            }
    
            return dp[n - 1];  
        }
    };
    