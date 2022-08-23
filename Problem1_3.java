//Time Complexity: O(m*n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_3 {

    public int maximalSquare(char[][] matrix)
    {
        if(matrix == null|| matrix.length == 0)
            return -1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        int temp =0, prev =0;
        
        int[] dp = new int[n+1];
        
        for(int i =0; i <m; i++)
        {
            for(int j =0; j <n; j++)
            {
               temp = dp[j+1];
               if(matrix[i][j] == '1')
               {
                   dp[j+1] = Math.min(dp[j], Math.min(dp[j+1], prev)) + 1;
                   max = Math.max(max, dp[j+1]);
               }
                
               else
                   dp[j+1] = 0;
                
               prev = temp; 
                
            }
        }
        return max*max; 
    
    }
}
