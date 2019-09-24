/*Time Complexity : O(mn)
Space Complexity : 
Did it run on LeetCode : yes
Any Problems: No

Dynamic Programming Solution.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
     int rows = matrix.length;
        int max=0;   // Create a max variable to compare curr and max. Then return Max*max;
        if(rows==0) return 0;
        int cols = matrix[0].length;
       
        int [] [] dp = new int[rows+1][cols+1]; // Size is taken as rows+1 and cols+1 to take care of edge cases.
        
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                 max=Math.max(max,dp[i][j]);
            }
           
        }
    return max*max;
    }
}
