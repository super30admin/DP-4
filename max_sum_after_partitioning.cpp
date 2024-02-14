// Time Complexity : O(kn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//loop through the array and determine the partitions based on the element
// position. if its valid partition then calculate max of elements in that 
// partition and calculate the sum of the elements in partition. For the next 
// partition we calculate the sum by taking previous element plus the max of 
// current elements in partition.  

#include<vector>

class Solution {
public:
    int maxSumAfterPartitioning(std::vector<int>& arr, int k) {
        int n = arr.size();
        std::vector<int> dp(n, 0);
        for(int i = 0; i < n; i++)
        {
            int maxNum = arr[i];
            for(int j = 1; j <= k && ((i - j + 1) >= 0) ; j++)
            {
                maxNum = std::max(maxNum, arr[i-j+1]);
                int curr = j*maxNum;
                if(i-j >= 0)
                {
                    curr = dp[i-j] + j*maxNum;
                }
                dp[i] = std::max(dp[i], curr);
            }
        }
        return dp[n-1];
    }
};