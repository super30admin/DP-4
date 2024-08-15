import java.util.Arrays;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) { //O(m*n) T.C, O(m*n) S.C
        int m = matrix.length;
        int n = matrix[0].length;
        //extra row and column of 0s in dp to cater for first row and column in matrix
        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                char c = matrix[i-1][j-1]; //take the character out from the matrix
                if(c == '1') { //If the character is '1'
                    //In the corresponding dp matrix, the value would be the min of its 3 neighbors(up, left, up-left)
                    // + 1. This value is the count of diagonal grids, i.e., the length of the current square.
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]); //We need to take the maximum length square out of the dp
                }
            }
        }
        return maxLength*maxLength; //By formula, the area of a square is its length^2.
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '1', '0', '0'},
                {'1', '1', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        };

        System.out.println("The maximum square length that can be formed from the given matrix: " +
                Arrays.deepToString(matrix) + " is: " + maximalSquare(matrix));
    }
}
