/*
The following solution uses a bottom-up dynamic programming approach to solve the problem. It computes the maximal
square at each location in the matrix by taking the minimum of the three values surrounding it, which is the diagonal
top left value, the top value, and the left value, and then adding one to this minimum. It stores these values in a 
separate matrix, and then uses them to calculate further values.

This approach uses a 1-D matrix to compute the maximal square. At each location, the given maximal square value is
computed by using the values to the left of it(which is already computed before it and present in the DP matrix), 
the diagonal at the top-left(which is the value that the left value had before it got re-computed), and the top
value, which is already present at the current location from the previous computation.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(n)
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        //A single dp matrix, which is one greater than the size of the number of columns is used for this computation,
        //so that at the start of each row a dummy value of 0 can be used for the left value.
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= m; i++)
        {   //At the start of each row the diagonal value is set to 0 since the leftmost element has no top-left diagonal
            int diag = 0;
            for(int j = 1; j <= n; j++)
            {   
                int temp = dp[j];
                if(matrix[i - 1][j - 1] == '1')
                {
                    dp[j] = 1 +  Math.min(diag, Math.min(dp[j - 1], dp[j]));
                    max = Math.max(max, dp[j]);
                }
                else
                    dp[j] = 0;
                //The previously computed maximal square value of the current location becomes the diagonal for the next computation
                diag = temp;
            }
        }
        
        return max * max;
    }
}