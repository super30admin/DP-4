# Time complexity:O(m*n)
# Space complexity: 0(m*n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0)
            return 0;


        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }

                    else{
                        dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                    }

                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max*max;
    }
}