/**
 * Time Complexity:
 * O(nk) where n is the number of columns and k is given
 */

/**
 * Space Complexity:
 * O(n)
 * 
 */

/**
 * Approach:
 * Dynamic Programming
 * 
 * We are given an array and we need to partition it. So first we tried the greedy
 * approach. But it failed for certain cases. Then we tried exhaustive approach and 
 * started making pairs. There we noticed the repeated subproblems. These subproblems
 * resulted in DP solution.
 * 
 * We observed that for each pair we can get the rest of the elements from 
 * the previous calculated sums. Then, we can take care of the edge cases too.
 * 
 */

//The code ran perfectly on leetcode





class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        vector<int> dp(arr.size());
        dp[0] = arr[0];
        for(int i = 1; i<dp.size(); i++){
            int maxVal = dp[i];
            for(int j = 1; j<= k && i -j + 1>= 0; j++){
                maxVal = max(maxVal, arr[i-j+1]);
                if( i - j >= 0){
                    dp[i] = max(dp[i], dp[i - j] + maxVal*j);
                } else {
                    dp[i] = max(dp[i], maxVal*j);
                }
            }
        }
        return dp[dp.size() -1];
        
    }
};