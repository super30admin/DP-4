// Time Complexity : O(mn)
// Space Complexity : O(mn)

public class MaximalSquare {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;
            int[][] result = new int[m+1][n+1];
            for (int i=1;i<=m;i++){
                for (int j=1;j<=n;j++){
                    if (matrix[i-1][j-1] == '1'){
                        result[i][j]= Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) +1;
                        res = Math.max(result[i][j], res);
                    } 
                }
            }
            //System.out.println(Arrays.deepToString(result));
            return res*res;
        }
    }
