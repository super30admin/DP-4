
/* Problem Statement: 
Verified on LeetCode
221. Maximal Square
Medium

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


 * Best Solution : DYNAMIC PROGRAMMING
 * Time Complexity : O(n*m) where n is number of rows, m is number of columns 
 * Space Complexity : O(n*m) for DP array 
 */
class Solution {
public:
    /* Approach is to go over each element one by one and start checking its neighbors 
    * for values. Get minimum of all its neighbors and then add 1 to that value to get the 
    * desired square size for that particular position. Take a look at the iterative for loop
    * for more details 
    */
    int maximalSquare(vector<vector<char>>& matrix) {
        int max_size = 0;
        int nrows = matrix.size();
        int ncols;
        int row_idx, col_idx, idx;
        
        if (0 == nrows) {
            return max_size;
        }

        ncols = matrix[0].size();
        /* Alternative to use Vector */
        //vector<vector<int>> dp;
        //dp.resize(nrows + 1, vector<int>(ncols + 1, 0));
        int dp[nrows+1][ncols+1];
        
        /* initialize with 0 for dp array */
        for (row_idx = 0; row_idx <= nrows; row_idx++) {
            for (col_idx = 0; col_idx <= ncols; col_idx++) {
                dp[row_idx][col_idx] = 0;
            }
        }
        
        /* go over rows and cols , and start from index 1 for taking care of the indices as dp array is 1 length extra for row and col */
        for (row_idx = 1; row_idx <= nrows; row_idx++) {
            
            for (col_idx = 1; col_idx <= ncols; col_idx++) {
                
                /* only interested in cases where value is 1 as it will make up the square */
                if (matrix[row_idx-1][col_idx-1] == '1') {
                    /* If we are at i,j position check for its neighbors ie diagonal upper, upper row and same row previous column */
                    dp[row_idx][col_idx] = min(min((dp[row_idx][col_idx - 1]), (dp[row_idx - 1][col_idx - 1])), (dp[row_idx - 1][col_idx])) + 1;
                    /* record max size possible for the square */
                    max_size = max(max_size, dp[row_idx][col_idx]);
                }
            }
        }
        /* Return area of square */
        return (max_size * max_size);
        
    }
};
