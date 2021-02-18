/*
method 1 : brute force of findgin cell with '1'.
then traverse diagonally if all elements are '1' in that col and row at every step.
update the max value;
time: O(m^2n^2)
space: O(1)


method 2: use dp[][]array to save repeated subproblems
time : O(mxn)
space : O(mxn)

method 3 : use 1d dp array tp save just the 3 cells we using to compare
time :O(mn)
space :O(n)
*/
class Solution {
    int m;
    int n;
    char[][]matrix;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
       
        
        //fall digaonal and check if all the cells are '1'
        int maxVal = 0;
        boolean flag = false;
        //method 1
//         for(int i = 0;i < m;i++){
//             for(int j = 0; j < n;j++){
//                 //check if current cell is '1'
//                 if(matrix[i][j] == '1'){
//                     //then fall digonallly and check if element is 1
//                     flag = true;
//                     int curr =1;
//                    // curr = findValidDiagonalNums(i,j,curr,flag);
                    
//                     while(i+curr < m && j+curr < n && flag){
//                         //check row
//                         for(int k = i+curr; k >= i;k--){
//                             if(matrix[k][j+curr] == '0'){
//                                 flag = false;break;
//                             }
//                         }
//                         //check col
//                         for(int k = j+curr; k >= j;k--){
//                             if(matrix[i+curr][k] == '0'){
//                                 flag = false;break;
//                             }
//                         }
//                         //if all are 1 then increment curr
//                         if(flag){
//                             curr++;
//                         }
//                     }
//                     maxVal = Math.max(maxVal,curr);
//                 }
//             }
//         }
        
        //method 2:
        // int[][]dp = new int[m+1][n+1];
        // for(int i = 1; i<= m;i++){
        //     for(int j = 1; j <= n;j++){
        //         if(matrix[i-1][j-1] == '1'){
        //             dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
        //             maxVal = Math.max(dp[i][j],maxVal);
        //         }
        //     }
        // }
        
        //method 3: 
        int[]dp = new int[n+1];
        int prev = 0;
        for(int i = 1; i<= m;i++){
            for(int j = 1;j <= n;j++){
            if(matrix[i-1][j-1] == '1'){
                int temp = dp[j];
                dp[j] = 1 + Math.min(dp[j],Math.min(prev,dp[j-1]));//top, left, topleft
                maxVal = Math.max(maxVal,dp[j]);
                prev = temp;
            }else{
                dp[j]  = 0;
            }
               
            }
        }
        
        return maxVal * maxVal;
    }
}