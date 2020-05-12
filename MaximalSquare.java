// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MaximalSquare {
        private int min(int a, int b, int c){
            int temp = Math.min(a, b);
            return Math.min(temp, c);
        }
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return 0;
            }

            int[][] dp = new int[matrix.length][matrix[0].length];

            int max = 0;

            for(int i = 0; i < matrix.length; i++){
                dp[i][0] = matrix[i][0] - '0';
                if(dp[i][0] == 1){
                    max = 1;
                }
            }

            for(int i = 0; i < matrix[0].length; i++){
                dp[0][i] = matrix[0][i] - '0';
                if(dp[0][i] == 1){
                    max = 1;
                }
            }

            // for(int i=0; i<matrix.length; i++){
            //     for(int j=0; j<matrix[0].length; j++){
            //         System.out.print(" "+ dp[i][j]);
            //     }
            //     System.out.println("");
            // }

            for(int i=1; i< matrix.length; i++){
                for(int j=1; j < matrix[0].length; j++){
                    if(matrix[i][j] - '0' == 0){
                        continue;
                    }

                    int temp = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                    dp[i][j] = temp + 1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }
            }

            // System.out.println("");

            // for(int i=0; i<matrix.length; i++){
            //     for(int j=0; j<matrix[0].length; j++){
            //         System.out.print(" "+ dp[i][j]);
            //     }
            //     System.out.println("");
            // }

            return max*max;
        }
}
