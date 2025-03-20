// https://leetcode.com/problems/partition-array-for-maximum-sum/description/
// Time Complexity: O(n*k)
// Space Complexity: O(n)

class Solution {
    public:
        int maxSumAfterPartitioning(vector<int>& arr, int k) {
            int n = arr.size();
            vector<int> dp(n+1,0);
    
            for(int i=n-1; i>=0;i--){
                int maxnum=0;
                int maxsum=0;
                for(int j=i; j < min(n, i+k); j++){
                    maxnum = max(maxnum,arr[j]);
                    maxsum = max(maxsum, dp[j+1] + maxnum*(j-i+1));
                }
                dp[i] = maxsum;
            }
            return dp[0];
        }
    };