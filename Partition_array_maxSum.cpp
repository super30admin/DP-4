// Time Complexity: O(n*k)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Create a dp array of size n where dp[i] represents the maximum sum that can be obtained by partitioning the array from 0 to i.
// 2. Initialize dp[0] = arr[0].
// 3. For each element in the array, find the maximum element in the last k elements and add it to the maximum sum obtained by partitioning the array from 0 to i - j.
// 4. Return dp[arr.size() - 1] as the maximum sum that can be obtained by partitioning the array.

class Solution {
    public:
        int maxSumAfterPartitioning(vector<int>& arr, int k) {
            vector<int> dp(arr.size());
            dp[0] = arr[0];
            for(int i = 1; i < arr.size(); i++){
                int maxElem = 0;
                for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                    maxElem = max(maxElem, arr[i - j + 1]);
                    if(i - j < 0){
                        dp[i] = max(dp[i], maxElem * j + 0);
                    }else{
                        dp[i] = max(dp[i], maxElem * j + dp[i - j]);
                    }
                    
                }
            }
            return dp[arr.size() - 1];
        }
    };