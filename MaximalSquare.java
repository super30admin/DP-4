//Time complexity : O(n * m) where n is the number of rows and m is cols
//Space complexity : O(n * m) where n is the number of rows and m is cols

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] DP = new int[matrix.length][matrix[0].length];
        
        int max = 0;

         for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    DP[i][j] = 0;
                } else {
                    DP[i][j] = 1;
                    max = 1;
                }
                
                System.out.print(DP[i][j] +" ");
            }
             System.out.println();
         }
        
        for(int i = 1; i < DP.length; i++) {
            for(int j = 1; j < DP[0].length; j++) {
                if(DP[i][j] != 0) {
                    DP[i][j] = Math.min(DP[i-1][j-1],Math.min(DP[i][j-1], DP[i-1][j])) + 1;
                    max = Math.max(DP[i][j], max);
                }
                System.out.print(DP[i][j] +" ");
            }
             System.out.println();
        }
        
        return max*max;
    }
}