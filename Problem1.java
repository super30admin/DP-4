public class Problem1 {
    // BrutForce solution
    // TC : O((mn) ^2)
    // SC : O(m*n)
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    boolean flag = true;
                    int curr = 1;
                    while (i + curr < m && j + curr < n && flag) {
                        for (int k = i; k <= i + curr; k++) {
                            if (matrix[k][j + curr] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            for (int k = j; k <= j + curr; k++) {
                                if (matrix[i + curr][k] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag) break;
                        curr++;
                    }
                    result = Math.max(result, curr);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        char[][] matrix = {{'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}};
        System.out.println("Final value " + problem1.maximalSquare(matrix));
    }
}
