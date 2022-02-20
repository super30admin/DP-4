// Time Complexity : O(mn) for optimized
// Space Complexity : O(n) for optimized
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

/*
For brute force we go on increasing the square diagonally down by moving on the diagonal
and checking if the corresponding row and col are all 1's, if yes we update our area
or can maintain a max variable as it is a square we can return the square of max


for dp approach we see that once we find the maximal square at one point, we can
use that to determine the maximal square for next cell since for each cell,
we need to find the minimum of squares formed from three sides, up, bottom and
diagonal left, since that is how the square can be increased.

we find the minimum as the smallest one makes sure that many 1s exist in all Three
sides and atleast that square can be formed using that cell. Only issue in the optimized dp
is that we may miss the diag up cell as we lose it everytime since we are maintaining
a single row, so for that we can maintain an extra variable for only diag up element
ehich reduces our space to n instead of the whole matrix mn.

*/

// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {

        // optimized dp approach O(mn)

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int dp[] = new int[n+1];

        int diagup = 0;

        for(int row = 1; row < m+1; row++)
        {
            for(int col = 1; col < n+1; col++)
            {
                if(matrix[row-1][col-1] == '1'){
                    int temp = dp[col];

                    dp[col] = Math.min(diagup, Math.min(dp[col-1],dp[col])) + 1;
                    max = Math.max(max,dp[col]);

                    diagup = temp;
                }
                else{
                    dp[col] = 0;
                }
            }
        }
         return max * max;

        //dp approach - O(mn) where m and n are the sizez of the matrix
        // space - O(mn)
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int dp[][] = new int[m+1][n+1];

        for(int row = 1; row < m+1; row++)
        {
            for(int col = 1; col < n+1; col++)
            {
                if(matrix[row-1][col-1] == '1'){

                    dp[row][col] = Math.min(dp[row-1][col-1],
                                            Math.min(dp[row-1][col], dp[row][col-1])) + 1;

                    max = Math.max(max,dp[row][col]);
                }
            }
        }

        return max * max;


    // brute force approach - O((mn)^2)
        // space - O(1)
        int maxArea = 0;
        int tempArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;


        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                int ceiling = row;
                int wall = col;
                 tempArea = 1;
                if(matrix[row][col] == '1')
                {

                    maxArea = Math.max(1,maxArea);
                    tempArea = 1;
                    boolean flag = false;


                    while(row + 1 < m && col + 1 < n
                            && matrix[row][col] == '1')
                    {
                        flag = true;
                        int tempRow = row + 1;
                        int tempCol = col + 1;
                        int diagRow = tempRow;
                        int diagcol = tempCol;


                        while(tempRow >= ceiling)
                        {
                            if(matrix[tempRow--][tempCol] == '1')
                                tempArea += 1;
                            else
                            {
                                flag = false;
                                break;
                            }
                        }

                        if(!flag) break;

                        tempCol -= 1;
                        row+= 1;
                        col += 1;
                        if(flag)
                        {
                            while(tempCol >= wall)
                            {
                                if(matrix[diagRow][tempCol--] == '1'){
                                    tempArea += 1;
                                }
                                else
                                {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if(flag){
                                maxArea = Math.max(maxArea, tempArea);
                            }
                        else{
                           break;
                        }

                    }
                }

                row = ceiling;
                col = wall;
            }
        }

        return maxArea;
    }
}
