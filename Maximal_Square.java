
//Approach:Recursion
//1. Here if I see a 1, then I iterate diagonally and see if the upper row and left column elements are 1 untill the current i and j, if we see a 0 then we cant form a square and we return
//2. We keep doing this for all elements of the matrix and find the square with max length then calculate the max area.

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        boolean flag = true; int max = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i < m ; i++)
        {
            for(int j=0; j < n;j++)
            {
                if(matrix[i][j] == '1')
                {                    
                    int currLen = 1; flag = true;
                    while((i + currLen) < m && (j + currLen) < n && flag)
                    {
                        for(int k = i+currLen; k >= i ; k--)
                        {
                            if(matrix[k][j + currLen] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j+currLen; k >= j ; k--)
                        {
                            if(matrix[i+currLen][k] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            currLen++;
                    }
                    max = Math.max(max,currLen);
                }
            }
        }
        return max * max;
    }
}
//Time Complexity : O(m ^ 2 * n ^ 2) 
//Space Complexity : O(mn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
class Maximal_Square {
	//Approach: Dynamic Programming
	//1. Here we add an extra row and a column before the actual rows and columns. if the array element is 1, then we compare all the neighbors and take the minimum add 1 with it.
	//2. we keep an max variable to store the max while iterating through all the elements
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
       
        for(int i=1; i < dp.length;i++)
        {
            for(int j=1; j < dp[0].length ;j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
//Time Complexity : O(mn) 
//Space Complexity : O(mn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
