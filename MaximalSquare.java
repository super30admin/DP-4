
/*

BruteForce
Time complexity: O(m^2*n^2)
constant space
worked on LC : YES
*/
class Solution {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;

        if(rows == 0) return 0;

        int curlen = 0;

        int cols = matrix[0].length;

        boolean flag = false;

        int maxLen = 0;

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){

                if(matrix[i][j] == '1'){

                    curlen = 1;

                    flag = true;

                    while(i + curlen < rows && j + curlen < cols && flag){

                        //[i+curlen] [j+curlen]

                        for(int k = i; k <= i+ curlen; k++){

                            if(matrix[k][j+curlen] == '0'){

                                flag = false;

                                break;

                            }

                        }

                        for(int k = j; k <= j+ curlen; k++){

                            if(matrix[i+curlen][k] == '0'){

                                flag = false;

                                break;

                            }

                        }

                        if(flag) curlen++;

                    }

                  maxLen = Math.max(maxLen, curlen);

                }

            }

        }

        return maxLen*maxLen;

    }

}


/*
DP solution
space and time complexity : O(m*N)
worked on LC : YES
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        int maxLength =0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m+1][n+1];
        
        // process first row
//         for(int i=0;i< m;i++) {
//             if(matrix[i][0] == '1') {
//                 dp[i][0] = 1;
//             }
//         }
        
//         // process first column
//         for(int i=0;i< n;i++) {
//             if(matrix[0][i] == '1') {
//                 dp[0][i] = 1;
//             }
//         }
        
        for(int i=1;i<= m;i++) {
            
            for(int j=1;j<=n;j++) {
                
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], 
                                   
                                   Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                
                   
                }
                 maxLength = Math.max(maxLength, dp[i][j]);
                
            }
        }
        
        return maxLength*maxLength;
        
        
        
    }
}
