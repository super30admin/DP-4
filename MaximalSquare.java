/**
 * Maximal Square — LeetCode 221
 * https://leetcode.com/problems/maximal-square/
 *
 * Approach:
 * This implementation uses a brute-force expansion approach. For every cell
 * that contains '1', it attempts to expand a square incrementally by 1 while
 * verifying the newly added top row and left column are all '1' (the helper
 * method performs these checks). The algorithm tracks the largest side
 * length found. This is simpler but less efficient than the DP solution.
 *
 * Time Complexity: O(m * n * min(m, n)^2) in the worst case. For each cell
 * we may expand up to side length s (<= min(m,n)), and each expansion checks
 * O(s) cells, leading to O(s^2) work per starting cell.
 * Space Complexity: O(1) extra space (ignoring input). The helper uses no
 * additional data structures.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int rLength = matrix.length;
        int cLength = matrix[0].length;

        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {

                if (matrix[i][j] == '1') {
                    int currentMax = 1;
                    int ci = i;
                    int cj = j;
                    while (ci + 1 < rLength && cj + 1 < cLength && matrix[ci + 1][cj + 1] == '1') {
                        if (helper(matrix, i, j, ci + 1, cj + 1)) {
                            currentMax++;
                            ci = ci + 1;
                            cj = cj + 1;
                        } else {
                            break;
                        }
                    }
                    max = Math.max(max, currentMax);
                }
            }
        }

        return max;

    }

    private boolean helper(char[][] matrix, int i, int j, int ci, int cj) {
        // check the new left column from row i..ci
        int ci1 = ci;
        while (ci1 >= i) {
            if (matrix[ci1][j] != '1') return false;
            ci1--;
        }
        // check the new top row from col j..cj
        int cj1 = cj;
        while (cj1 >= j) {
            if (matrix[i][cj1] != '1') return false;
            cj1--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Provided matrix: [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] matrix = new char[][]{
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        MaximalSquare ms = new MaximalSquare();
        int side = ms.maximalSquare(matrix);
        int area = side * side;
        System.out.println("Maximal square side length = " + side);
        System.out.println("Maximal square area = " + area);
    }
}
