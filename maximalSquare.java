// Time Complexity : O(m^2n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* We run the bruteforce approach where we iterate through the matrix and see of there is 1 present.
 * if so, then we keep a boolean flag as true and check for the consecutive row and column and diagonal till there exists a square.
 * Keep a max variable which keep keep track of the length of the square. return area at the end.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0 ;
        for(int i = 0 ; i< m; i++)
        {
            for(int j = 0 ; j < n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    boolean flag = true;

                    int len = 1;

                    while(i+len < m && j+ len < n && flag)
                    {
                        //check for column
                        for(int r = i + len ; r >= i ; r--)
                        {
                            if(matrix[r][j+ len] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        //check for row
                        for(int c = j + len ; c>= j ;c--)
                        {
                            if(matrix[i+len][c] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            len++;
                        }
                    }

                    max = Math.max(max, len);
                }
            }
        }

        return max * max;

    }
}




// dp

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* we do dp solution where we take add 1 to min of the previous row, column and diagonal. and keep track of the length;
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1 ; i <= m ; i++)
        {
            for(int j = 1; j <= n ;j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;

    }
}