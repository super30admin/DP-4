// TC: O(M*N)
// SC: O(M*N)
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
               return 0;
    }
}


// TC: O(M*N)
// SC: O(M*N)
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
               return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;
        for ( int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
                if (matrix[i-1][j-1] == '1')
                {
                   // current cell = 1 + min(up cell , left cell, digaonal cell) of dp 
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) ;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}


// TC: O(MN)^2
// SC: O(1)
// Did it run sucessfully on Leetcode? : Yes
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         if (matrix == null || matrix.length == 0)
//                return 0;
//         int m = matrix.length;
//         int n = matrix[0].length;
//         boolean flag = false;
//         int max = 0;
//         for ( int i = 0; i < m; i++)
//         {
//             for ( int j = 0; j < n; j++)
//             {
//                 if (matrix[i][j] == '1')
//                 {
//                     flag = true;
//                     int curr = 1;
//                     while (i + curr < m && j + curr < n && flag)
//                     {
//                         // now at = i+curr and j+curr index
//                         // check in same column if we have '0'
//                         for (int k = i + curr; k >= i ; k--)
//                         {
//                             if(matrix[k][j+curr] == '0')
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         // check in same row if we have '0'
//                         for (int k = j + curr; k >= j ; k--)
//                         {
//                             if(matrix[i+curr][k] == '0')
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         if (flag)
//                           curr++;
//                     }
//                      max = Math.max(max, curr);  // curr will have length of squarefound at i, j
//                 } 
//             }
//         }
//        return max * max;
//     }
// }
