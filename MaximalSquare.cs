using System;
using System.Collections.Generic;
using System.Text;

namespace DP
{
    class MaximalSquareLC
    {
        //TC"O(mn) ^2
        //SC:O(1)
        public int MaximalSquare(char[][] matrix)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return 0;
            }
            int m = matrix.Length;
            int n = matrix[0].Length;
            int max = 0;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; i < n; j++)
                {
                    if (matrix[i][j] == '1')
                    {
                        int curr = 1;
                        bool valid = true;
                        while (i + curr < m && j + curr < n)
                        {
                            //check upward direction
                            for (int k = i + curr; k >= i; k--)
                            {
                                if (matrix[k][j + curr] == '0')
                                {
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid) break;
                            //check leftwards
                            for (int k = j + curr; k >= j; k--)
                            {
                                if (matrix[i + curr][k] == '0')
                                {
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid) break;
                            curr++;
                        }
                        max = Math.Max(max, curr);
                    }
                }
            }
            return max * max;
        }
        //TC: O(m*n)
        //SC: O(m*n)
        public int MaximalSquareDP(char[][] matrix)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return 0;
            }
            int m = matrix.Length;
            int n = matrix[0].Length;
            int[,] dp = new int[m + 1,n + 1];
            int max = 0;
            for (int i = 1; i <= m; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (matrix[i - 1][j - 1] == '1')
                    {
                        dp[i,j] = Math.Min(dp[i,j - 1], Math.Min(dp[i - 1,j], dp[i - 1,j - 1])) + 1;
                        max = Math.Max(max, dp[i,j]);
                    }
                }
            }
            return max * max;
        }

        //TC: O(m*n)
        //SC: O(n)
        public int MaximalSquareMostOptimal(char[][] matrix)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return 0;
            }
            int m = matrix.Length;
            int n = matrix[0].Length;
            int[] dp = new int[n + 1];
            int max = 0;
            int prev = 0;
            for (int i = 1; i <= m; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (matrix[i - 1][j - 1] == '1')
                    {
                        int temp = dp[j];
                        dp[j] = Math.Min(dp[j - 1], Math.Min(dp[j], prev)) + 1;
                        max = Math.Max(max, dp[j]);
                        prev = temp;
                    }
                    else
                    {
                        dp[j] = 0;
                    }
                }
            }
            return max * max;
        }
    }
}
