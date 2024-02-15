// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Method used : DP

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;

        // At each and every snapshot I need only 3 values so better maintain a 1D array
        int[] dp = new int[cols + 1];

        int maximum = Integer.MIN_VALUE, diagonal_value = 0;

        for(int i = 1; i < rows + 1; i++)
        {
            for(int j = 1; j < cols + 1; j++)
            {
                // In the previous case when we were at dp[i][j], we were finding minimum between dp[i - 1][j - 1], 
                // dp[i - 1][j] and dp[i][j - 1]. When we use 1D array we can still get left value which is dp[j - 1]
                // But how to get top and diagonal value.

                // Temp value will store the diagonal value will be at dp[j] in previous snapshot, we need to 
                // store that in a variable. It would be dp[j] not dp[j - 1] bcoz we are stroring dp[j] as diagonal 
                // value and when j gets incremented this dp[j] value will be the diagonal value for dp[j + 1]
                int temp = dp[j];

                if(matrix[i - 1][j - 1] == '1')
                {
                    // Consider the minimum element among top, left and diagonal element
                    // dp[j] is the top value, that will already be present in the current array bcoz we didn't compute
                    // it yet. dp[j - 1] is the left value
                    // Above in temp variable we are storing dp[j] which is the top value for current value and it is 
                    // also the diagonal value to the next element at index j + 1. That's the reason we stored that 
                    // value in temp. 
                    dp[j] = 1 + Math.min(diagonal_value, Math.min(dp[j], dp[j - 1]));

                    // Keep track of maximum always 
                    maximum = Math.max(maximum, dp[j]);
                }

                else
                {
                    // We have to do this, if we don't do this then we keep computing minimum values. What if all the 
                    // 3 values are positive then dp[j] would never become 0. So when matrix element is 0 explicitly
                    // store 0 in dp array
                    dp[j] = 0;
                }

                // This is the reason we used temp variable to store the previous diagonal value and now we can update
                // this in our diagonal variable
                // If I didn't used temp varaible and said diagonal_value = dp[j], this wouldn't have worked bcoz
                // value of dp[j] will change in the conditional statements. So better store it first
                diagonal_value = temp;
            }
        }

        return maximum * maximum;
    }
}