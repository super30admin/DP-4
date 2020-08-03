//Prepare a dp array with dimension [m+1, n+1]
//dp is calculated by taking index of min value of( immediate up,immediate left and immediate diagonal up) +1
//dp with max value is the square
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
       
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int [m+1][n+1];
        int max = 0;
        for(int i = 1; i < dp.length;i++){
            for(int j = 1; j <dp[0].length;j++){
                if(matrix[i-1][j-1] == '1'){ // i is iterator of dp array
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                     max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max* max;
    }
}

/*
Time complexity: O(mxn)
Space complexity:O(1)
*/




//Brute force
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
     
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                //check for diagonal
                if(matrix[i][j] == '1'){
                   int curr = 1 ;flag = true; // flag  check for square formation
                    while(i+curr < m && j+curr < n && flag){
                       
                        //traversing column 'up' till ceiling
                        for(int k = i+curr; k >= i; k--){
                            if(matrix[k][j+curr] == '0' ){
                                flag = false;
                                break;
                            }
                        }
                        //traversing row to 'left'
                        for(int k = j+curr; k>=j ; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                       
                        if(flag) curr++;
                    }  
                    //diagonal length curr has to be reset outside the while for ["1"], ["0","1"] inputs
                        max = Math.max(max,curr);
                }
                }
            }
            return max*max;
        }
       
    }


/*
Time Complexity: O(m^2 x n^2) -- For each index with value 1 entire matrix is  explored for square
Space Complexity: O(1)

*/