// Time Complexity :O(n) where n is the size of the array
// Space Complexity : O(n)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        vector<int> dp(arr.size());
        dp[0] = arr[0];
        int maxVal;
        for(int i=1; i<dp.size();i++){
            maxVal= arr[i];
            for(int j = 1;j <=k && i-j+1>=0; j++){
                maxVal = max(maxVal,arr[i-j+1]);
                if(i-j >= 0){
                    dp[i] = max(dp[i],(maxVal * j) +dp[i-j]);
                }
                else {
                    dp[i] = max(dp[i],(maxVal * j));
                }
            }
        }
        return dp[dp.size()-1];
    }
};