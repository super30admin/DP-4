import java.util.Scanner;

public class MaximalSquareAreaInBinaryMatrixDynamicProgramming {

        //DYNAMIC PROGRAMMING - O(M*N) TIME AND O(M*N) SPACE

        //Family of problems - maximal square or rectangle or benzene ring

        public int maximalSquare(char[][] matrix) {

            // null case
            if(matrix == null)      return 0;

            // dimensions of matrix
            int m = matrix.length;
            int n = matrix[0].length;

            // initial side
            int maxSide = 0;

            //DP array
            int[][] dp = new int[m+1][n+1];       //  O(M*N) space

            // building dp array for which 0th row and 0th column are zeros
            for(int i = 1; i <= m; i++) {         //  O(M*N)

                for(int j = 1; j <= n; j++) {

                    // equivalent value in original matrix will be at a row and column less than in dp array
                    // i.e., zeroth row or column in original matrix = the first row or column in dp array
                    // DP value is updated only if corresponding matrix value is 1, DP value will be zero by default otherwise i.e., if original matrix value also is zero
                    if(matrix[i-1][j-1] == '1') {

                        // dp value will be minimum of those at up, left, diagonal up left + 1
                        // minimum of three determines square size that can be formed at current location
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));

                        // maximum side is updated for every DP value just formed
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            // output maximal square area
            return maxSide*maxSide;
        }

        public static void main(String[] args) {

            MaximalSquareAreaInBinaryMatrixDynamicProgramming obj =
                    new MaximalSquareAreaInBinaryMatrixDynamicProgramming();

            Scanner scanner = new Scanner(System.in);

            System.out.println("m: ");
            int m = scanner.nextInt();

            System.out.println("n: ");
            int n = scanner.nextInt();

            char[][] matrix = new char[m][n];

            System.out.println("Binary matrix: ");
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    matrix[i][j] = scanner.next().charAt(0);
                }
            }

            int answer = obj.maximalSquare(matrix);

            System.out.println("Maximal square area is " + answer);
        }


}


/*
TIME COMPLEXITY = O(M*N)

O(M*N) time to build DP array

SPACE COMPLEXITY = O(M*N)

O(M*N) space for DP array
*/

