//Brute Force Solution

// Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes but Time limit exceeded when submitted- 36 / 46 test cases passed.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length; int n = matrix[0].length;
        
        boolean flag = false; int max = 0;
        for(int i = 0; i<m ; i++){
             for(int j = 0; j<n ; j++){
                 if(matrix[i][j] == '1'){
                     flag = true; int curr = 1;
                     while(i + curr < m && j + curr < n & flag == true){
                         //iterate on collumn
                         for(int k = i + curr; k>=i; k--)
                         {
                           if(matrix[k][j+curr] == 0)flag =false;
    
                         }
                         //iterate on collumn
                           for(int k = j + curr; k>=j; k--)
                         {
                           if(matrix[i + curr][k] == 0)flag = false;
    
                         }
                         if(flag == true) curr++;
                         
                     }
                     max = Math.max(max, curr);
                     
                 }
                 
            }
        }
        return max;
    }
}


//DP Solution

// Time Complexity : O(m X n)
//Space Complexity : O(m X n)
//Did this code successfully run on Leetcode : Yes but Time limit exceeded when submitted- 36 / 46 test cases passed.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length; int n = matrix[0].length;
        
         int max = 0;
         
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<dp.length;i++){
            for (int j = 1; j< dp[0].length ; j++){
                 if(matrix[i-1][j-1] == '1'){
                     dp[i][j] = 1+ Math.min(dp[i-1][j ], Math.min(dp[i][j-1], dp[i-1][j-1]));
                     max = Math.max(max, dp[i][j]);
                 }
            }
        }
        return max*max;
    }
}