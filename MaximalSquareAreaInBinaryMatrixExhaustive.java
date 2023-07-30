import java.util.Scanner;

public class MaximalSquareAreaInBinaryMatrixExhaustive {

        //BRUTE FORCE - O((M*N)^2) TIME AND O(1) SPACE

        //Family of problems - maximal square or rectangle or benzene ring

        public int maximalSquare(char[][] matrix) {

            // null case
            if(matrix == null)      return 0;

            // dimensions of matrix
            int m = matrix.length;
            int n = matrix[0].length;

            // initial side
            int maxSide = 0;

            // iterate over whole matrix as pivot = all (i,j)
            for(int i = 0; i < m; i++) {     // O(M*N)

                for(int j = 0; j < n; j++) {

                    if(matrix[i][j] == '1') {

                        int temp = 1;

                        boolean flag = true;

                        //keep check point = fall down diagonally within bounds
                        while(i + temp < m && j + temp < n && flag) {  // O(M*N)

                            // column up check from check point
                            for(int row = i + temp; row >= i; row -- ) {

                                // varying row only
                                if(matrix[row][j + temp] == '0') {

                                    //
                                    flag = false;

                                    // stop processing from the pivot (i,j)
                                    break;
                                }
                            }

                            // row left check from check point
                            for(int col = j + temp; col >= j; col --) {

                                // varying column only
                                if(matrix[i + temp][col] == '0') {

                                    //
                                    flag = false;

                                    // stop processing from the pivot (i,j)
                                    break;
                                }
                            }

                            // move further diagonal down for enhancing area
                            // within while loop step, as bound check is because of this increment
                            if(flag) temp++;
                        }

                        // update maximum side length of square after every processing break i.e., after while loop
                        maxSide = Math.max(maxSide, temp);

                    }
                }
            }
            // output maximal square area
            return maxSide*maxSide;

        }

        public static void main(String[] args) {

            MaximalSquareAreaInBinaryMatrixExhaustive obj = new MaximalSquareAreaInBinaryMatrixExhaustive();

            Scanner scanner = new Scanner(System.in);

            System.out.print("m: ");
            int m = scanner.nextInt();

            System.out.print("n: ");
            int n = scanner.nextInt();

            char[][] matrix = new char[m][n];

            System.out.println("Binary matrix: ");

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    matrix[i][j] = scanner.next().charAt(0);
                }
            }

            int answer = obj.maximalSquare(matrix);

            System.out.println("Maximal square area is " + answer);

        }

}

/*
TIME COMPLEXITY = O((M*N)^2)

//nested while loop O(M*N) * for each processing O(M*N) = O((M*N)^2)

SPACE COMPLEXITY = O(1)

Good part of brute force solution = No extra space used
*/
