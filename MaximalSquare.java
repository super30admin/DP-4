class MaximalSquare {
    // Time Complexity :O(m*n*m*n)  where m is the number of rows and n is the number of columns
    // Space Complexity : O(m*n*m*n)
    // Did this code successfully run on Leetcode :yes
    public int maximalSquareBF(char[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return 0;
        }

        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        int maxSqLength = 0;

        for(int i =0; i<numberOfRows; i++){
            for(int j=0; j<numberOfColumns; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    boolean flag = true;

                    while(flag && i+l < numberOfRows && j+l < numberOfColumns){
                         //check in the same row
                        for(int k = j+l; k>=j; k--){
                            if(matrix[i+l][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //check in the same column
                        for(int k = i+l; k>=i; k--){
                            if(matrix[k][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //expand the range
                        if(flag){
                            l++;
                        }
                    }
                    maxSqLength = Math.max(maxSqLength, l);
                }
            }
        }
        return maxSqLength * maxSqLength;
    }

    // Time Complexity :O(m*n) where m is the number of rows and n is the number of columns
    // Space Complexity : O(m*n)
    // Did this code successfully run on Leetcode :yes
    public int maximalSquare(char[][] matrix) {
         if(matrix == null || matrix.length < 1){
            return 0;
        }
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int maxSquareSize = 0;

        int[][] dp = new int[numberOfRows+1][numberOfColumns+1];

        for(int i=1; i<=numberOfRows; i++){
            for(int j=1; j<=numberOfColumns; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],
                    Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;

                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }
        return maxSquareSize*maxSquareSize;
    }

    // Time Complexity :O(m*n) where m is the number of rows and n is the number of columns
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode :yes
    public int maximalSquareSpaceOptimized(char[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int maxSquareSize = 0;

        int[] dp = new int[numberOfColumns+1];

        for(int i=1; i<=numberOfRows; i++){
            int diagUp = 0;
            for(int j=1; j<=numberOfColumns; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(dp[j],
                            Math.min(dp[j-1], diagUp)) + 1;

                    maxSquareSize = Math.max(maxSquareSize, dp[j]);
                }
                diagUp = temp;
            }
        }
        return maxSquareSize*maxSquareSize;
    }
}
