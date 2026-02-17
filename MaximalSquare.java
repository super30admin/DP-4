public class MaximalSquare {
    public int maximalSquare(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        //create an empty DP matrix by default all values will be 0
        int[][] dp = new int[rows][cols];
        //fill the dp matrix
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //since we only need largest squares from 1's
                if(matrix[i][j] == '1'){
                    //handling first row and col as it doesnt have neighbors
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        //check top,left and top-left neighbors
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                    }
                }
                maxArea = Math.max(maxArea, dp[i][j]);
            }
        }
        //return area of largest square
        return maxArea * maxArea;
    }
}

//TC: O(M*N)
//SC: O(M*N)