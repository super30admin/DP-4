class Solution {
    public int maximalSquare(char[][] matrix) {
        //We have to find out about the neighbors, BFS?
        //but a special type of BFS. If there is not going to be any visited array then this BFS will keep running forever.   
        //Always check the l-shaped neighbors before pushing them into the queue. If all the 3 are not 1 then you have to return
        
        
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[ROWS + 1][COLS + 1];
        //We need to create a matrix with one extra row and column.
        //Start from the last cell of this grid which is at the bottom left corner of the grid.
        
        //The solution given here is very different. These people have started from the non - edge elements. from (1, 1)  
            //We have done 
        
            for(int i = 1; i <= ROWS; i++){
                for(int j = 1; j <= COLS; j++){
                    //Check the diagonally previous element of the current element.
                    
                    if(matrix[i - 1][j - 1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                }
            }
        return maxLen * maxLen;
    }
}