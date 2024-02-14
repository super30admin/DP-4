// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Starting from bottom, if matrix element is 1 then calculate min of right element, down element and 
// diagdown towards right plus 1 and store in dp array. repeat this until all 1s are covered in matrix. 
// get the max length from dp array and return area from the max length.

#include<vector>

class Solution {
public:
    int maximalSquare(std::vector<std::vector<char>>& matrix) {
        int m = matrix.size();
        if(m == 0)
        {
            return 0;
        }
        int n = matrix[0].size();
        std::vector<int> dp(n+1, 0);
        int result = 0;

        for(int i = m-1; i>=0; i--)
        {
            int diagdown = 0;
            for(int j = n-1; j >=0; j--)
            {
                if(matrix[i][j] == '1')
                {
                    int temp = dp[j];
                    dp[j] = 1 + std::min(dp[j+1], std::min(dp[j], diagdown));
                    result = std::max(result, dp[j]);
                    diagdown = temp;
                }
                else
                {
                    dp[j] = 0;
                }
            }
        }

        return result*result;
    }
};