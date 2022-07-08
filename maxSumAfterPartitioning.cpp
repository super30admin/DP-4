// Time Complexity : O(n * k) 
// Space Complexity : O(n)
//          where n :- size of i/p array
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build DP array to store maximum partition value that can be achieved till current index.
 * Iterate over each element, while iterating over each element go back till k elements (k choices) to compute 
 * the max possible value.
 * Use DP array to get previous partion values which are already computed. 
 */

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        if (arr.size() == 0)
        {
            return 0;
        }
        
        int dp[arr.size()];
        
        for (int i = 0; i < arr.size(); i++)
        {
            dp[i] = 0;
        }
        
        dp[0] = arr[0];
        
        for (int i = 1; i < arr.size(); i++)
        {
            int max = arr[i];
            
            for (int j = 1; j <= k && i - j + 1 >= 0; j++)
            {
                max = std::max(max, arr[i - j + 1]);
                
                if (i - j >= 0)
                {
                    dp[i] = std::max(dp[i], dp[i - j] + max * j);
                }
                else
                {
                    dp[i] = std::max(dp[i], max * j);
                }
            }
        }
        
        return dp[arr.size() - 1];
    }
};