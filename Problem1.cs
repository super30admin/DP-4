// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I start traversing the matrix from (1,1) position. Whenever I come across a '1', I check if it is the right most edge of a square - if so then I update it's value to min of it's 3 neighbours
    and add 1 to it. This represents the size of max square that can be formed at that position.
*/

public class Solution
{
    public int MaximalSquare(char[][] matrix)
    {
        int rows = matrix.Length, columns = matrix[0].Length;

        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < columns; j++)
            {
                if (matrix[i][j] == '1')
                {
                    // Get the minimum of it's three neighbours and add 1 to it and assign that to it's value
                    int up = matrix[i - 1][j] - '0';
                    int left = matrix[i][j - 1] - '0';
                    int diagonalLeft = matrix[i - 1][j - 1] - '0';

                    matrix[i][j] = (char)(1 + Math.Min(up, Math.Min(left, diagonalLeft)) + '0');
                }
            }
        }

        int side = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                side = Math.Max(side, matrix[i][j] - '0');
            }
        }

        return side * side;
    }
}