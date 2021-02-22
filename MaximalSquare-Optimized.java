//Problem 106: Maximal Square -Optimized using DP
//TC: O(mn)
//SC: O(mn)

/*Steps
Optimized: 1) Create a DP of size m+1 and n+1;
           2) Iterate over DP starting i=1 and j=1.
           3) If matrix element at the DP index is 1, then find minimum of 3 sides which are top, top left, left and add +1;
           4) Finally return the area of square

    //Maximal Square
     0 1 2 3 4 5
    [ 
    [0 0 0 0 0 0]
    [0 1 0 1 0 0]
    [0 1 0 1 1 1]
    [0 1 1 1 2 2]
    [0 1 0 0 1 0]
    ]

*/

class Solution106Optimised {
   
    public int maximalSquare(char[][] matrix) {
        
        //where u find 1, then add 1 + (minimum of 3 sides top, top left, left)
        //TC:O(m*n) |SC:O(mn)
        if(matrix==null || matrix.length==0) return 0;
        
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        
        return max*max;
    }

}