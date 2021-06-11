//Dp approach
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        //use a dp array to store the minimum possible squares  possible from every cell
        int[][] dp = new int[row+1][col+1];//no extra row and col is used to act as a base case for the first row and first col in the input array
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                //if the current cell is 1 in the i/p array,continue
                if(matrix[i-1][j-1]=='1'){
                    //check in dp array the top left diagonal,left and top cell from the current cell and take minimum of them + 1
                    //if all are zero's then the maximum possible square possible is 1
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
                //determine the max at each cell
                max = Math.max(max,dp[i][j]);
            }
        }
        //since the square has to be returened
        return max*max;
    }
}
//Brute force
//Time Complexity : O(m*n)^2
//Space Complexity : O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int cur;
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    cur = 1;
                    boolean isValid = true;
                    //go the rightdown diagonal and start checking for squares towards left and top from current cell
                    while(i+cur<row && j+cur<col && isValid){
                        //checking downwards : rows
                        for(int k = i+cur;k>=i;k--){
                            if(matrix[k][j+cur]=='0'){
                                isValid = false;
                                break;//as there is no poin going forward
                            }
                        }
                        //if no zeros were found down then go for (right)cols
                        if(isValid){
                            for(int k=j+cur;k>=j;k--){
                                if(matrix[i+cur][k]=='0'){
                                    isValid = false;
                                    break;
                                }
                            }
                        }
                        //if no zeros were found in both the directions then continue
                        if(isValid){
                            cur++;//found a square
                        }
                    }
                    //check for max
                    max = Math.max(max,cur);
                }
            }
        }
        //since the square has to be returened
        return max*max;
    }
}