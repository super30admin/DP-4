class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int[] dp = new int[col+1];

        for(int i = row - 1; i >= 0; i--){
            int diagonal = 0;
            for(int j = col - 1; j >= 0; j--){
                int temp = dp[j];
                if(matrix[i][j] == '1'){
                    dp[j] = 1 +  Math.min(dp[j], Math.min(dp[j+1], diagonal));
                }else{
                    dp[j] = 0;
                }
                result = Math.max(dp[j], result);
                diagonal = temp;
            }
        }
        return result*result;
    }
}
