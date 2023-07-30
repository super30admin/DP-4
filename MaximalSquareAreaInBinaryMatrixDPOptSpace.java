import java.util.Scanner;

public class MaximalSquareAreaInBinaryMatrixDPOptSpace {

        //DYNAMIC PROGRAMMING - OPTIMIZED SPACE -  O(M*N) TIME AND O(N) SPACE

        //Family of problems - maximal square or rectangle or benzene ring

        public int maximalSquare(char[][] matrix) {

            // null case
            if(matrix == null)      return 0;

            // dimensions of matrix
            int m = matrix.length;
            int n = matrix[0].length;

            // initial side
            int maxSide = 0;

            // 1D DP array
            int[] dp = new int[n+1];         // O(N) space

            // building DP array
            for(int i = 1; i <= m; i++) {    // O(M*N) TIME

                // DP array's zeroth column's zero
                int diagUpLeft = 0;

                for(int j = 1; j <= n; j++) {

                    // store 1D dp value before it gets modified
                    int up = dp[j];

                    //equivalent original matrix value is one
                    if(matrix[i-1][j-1] == '1') {

                        // minimum of up, left and diagonal up left
                        dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUpLeft));
                    }
                    else {

                        // otherwise, make dp value zero
                        // in 2D DP array, zero is by default. In 1D DP array, zero has to be made
                        dp[j] = 0;
                    }

                    //  current up DP value will be diagonal up left DP value for next pivot in a row
                    diagUpLeft = up;

                    //update maximum side
                    maxSide = Math.max(maxSide, dp[j]);
                }
            }

            // output maximal square area
            return maxSide*maxSide;
        }

        public static void main(String[] args) {

            MaximalSquareAreaInBinaryMatrixDPOptSpace object = new MaximalSquareAreaInBinaryMatrixDPOptSpace();

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

            int answer = object.maximalSquare(matrix);

            System.out.println("Maximal square area is " + answer);
        }
}

/*
TIME COMPLEXITY = O(M*N)

O(M*N) time to build DP array

SPACE COMPLEXITY = O(N)

O(N) space for 1D - DP array
*/