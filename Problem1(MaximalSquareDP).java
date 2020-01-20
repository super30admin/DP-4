/* Dynamic Programing Solution Algorithm:
    - Create one more matrix of one extra col n row of the original.
    - Now, If there is a one at respective positon of orignal matrix then we check for up, left, diagnolly left position take the min out of it and save at the respective position.
    - This saved value gives the max lenght of matrix with 1s which can formed till that point, we return the max value of total matrix.
    
    
    Time Complexity: O(mn)
    Space Complexity: O((m+1)(n+1)
    
    Did the code run on leetcode? Yes
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row==0)
            return 0;
        int col = matrix[0].length;
        
        int max = 0;
        int dp[][] = new int[row+1][col+1];
        
        for(int i=1 ; i<dp.length; i++){
            for(int j=1 ; j<dp[0].length; j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]= Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) +1 ;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max*max;
    }
}