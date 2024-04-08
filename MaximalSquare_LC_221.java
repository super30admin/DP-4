// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : how to expand the size of the square

// (https://leetcode.com/problems/maximal-square/)

// Algo:
/**
 * Brute: at each (r, c) == '1' in the matrix, i.e., the start of the square(top-left corner),:
 * try to expand the size of the square by moving in Left, Down, Diagonal
 * directions.
 * 
 * using a BFS approach, consider all the nodes which increase the size by 1 at
 * the same level.
 * Here, # of levels = size of the square
 * 
 * TC: O(mn) * O(mn) = O(mn)^2
 * for each (r,c), in the worst case (entire matrix = '1'), we'd end up
 * traversing the whole matrix again.
 * 
 * SC: O(m + n) due to queue for BFS
 */

/**
 * Brute Optimized:
 * Overcome SC:O(m+n)
 * 
 * NOTE: for a square, length of diagonal == length of side
 * 
 * for each (r,c) as the start of the square(top-left corner), just traverse
 * diagonally(r+1, c+1), such that all indices
 * in the same column(c+1) till r(upper boundary), and in the same row(r+1) till
 * c(left boundary) should also be '1'
 * 
 * if so, increase the size for current square by 1
 * 
 * TC: O(mn)^2
 */

import java.util.ArrayDeque;

/**
 * NOTE: in the above solutions, we need up having repeated sub-problems -->
 * hence, apply DP
 * 
 * if we start from (0,0) --> move towards (m-1, n-1)
 * 
 * maxSq[r][c] = Math.min(top, left, diagonal) + 1
 * 
 * i.e. the current index (r, c) can join with the min. possible square in these
 * 3 directions to form a new bigger square.
 */

public class MaximalSquare_LC_221 {

    private class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /*
     * TLE
     * 
     * TC: O(mn) * O(mn) = O(mn)^2
     * for each (r,c), in the worst case (entire matrix = '1'), we'd end up
     * traversing the whole matrix again.
     * 
     * SC: O(m + n) due to queue for BFS
     */
    public int maximalSquare_bfs(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    ArrayDeque<Pair> queue = new ArrayDeque<>();
                    int side = 0;
                    queue.offer(new Pair(r, c));
                    boolean flag = true;
                    while (!queue.isEmpty() && flag) {
                        side++;
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            Pair pop = queue.poll();
                            char down = pop.r + 1 < m ? matrix[pop.r + 1][pop.c] : '0';
                            char right = pop.c + 1 < n ? matrix[pop.r][pop.c + 1] : '0';
                            char diagonal = pop.r + 1 < m && pop.c + 1 < n ? matrix[pop.r + 1][pop.c + 1] : '0';
                            if (down != '1' || right != '1' || diagonal != '1') {
                                flag = false;
                                break;
                            } else {
                                queue.offer(new Pair(pop.r + 1, pop.c));
                                queue.offer(new Pair(pop.r, pop.c + 1));
                                queue.offer(new Pair(pop.r + 1, pop.c + 1));
                            }
                        }
                    }
                    max = Math.max(max, side);
                }
            }
        }

        return max * max;
    }

    /*
     * NO TLE
     * 
     * TC: O(mn) * O(mn) = O(mn)^2
     * for each (r,c), in the worst case (entire matrix = '1'), we'd end up
     * traversing the whole matrix again.
     * 
     * SC: O(1)
     */
    public int maximalSquare_diagonalTraversal(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // start: top-left corner of square
                if (matrix[r][c] == '1') {
                    int side = 1;

                    int dR = r + 1;
                    int dC = c + 1;

                    boolean flag = true;
                    while (flag && dR < m && dC < n) {
                        // check current column
                        for (int i = dR; i >= r; i--) {
                            if (matrix[i][dC] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        // check current row
                        for (int j = dC; j >= c && flag; j--) {
                            if (matrix[dR][j] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            dR++;
                            dC++;
                            side++;
                        }
                    }

                    max = Math.max(max, side);
                }
            }
        }
        return max * max;
    }

    /*
     * TC: O(mn)
     * SC: O(mn) due to dp[][]
     */
    public int maximalSquare_memoize(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        // base case
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == '1') {
                dp[r][0] = 1;
                max = 1;
            }
        }
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == '1') {
                dp[0][c] = 1;
                max = 1;
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                // start: top-left corner of square
                if (matrix[r][c] == '1') {
                    int top = dp[r - 1][c];
                    int left = dp[r][c - 1];
                    int diagonal = dp[r - 1][c - 1];

                    dp[r][c] = Math.min(top, Math.min(left, diagonal)) + 1;

                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        return max * max;
    }

    /*
     * TC: O(mn)
     * SC: O(mn) due to dp[][]
     */
    public int maximalSquare_memoize2(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // base case
        int[][] dp = new int[m + 1][n + 1];

        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    int top = dp[r - 1][c];
                    int left = dp[r][c - 1];
                    int diagonal = dp[r - 1][c - 1];

                    dp[r][c] = Math.min(top, Math.min(left, diagonal)) + 1;

                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        return max * max;
    }

    /*
     * TC: O(mn)
     * SC: O(n)
     */
    public int maximalSquare_spaceOptimize(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // base case
        int[] dp = new int[n + 1];

        for (int r = 1; r <= m; r++) {
            int[] curr = new int[n + 1];
            for (int c = 1; c <= n; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    int top = dp[c];
                    int left = curr[c - 1];
                    int diagonal = dp[c - 1];

                    curr[c] = Math.min(top, Math.min(left, diagonal)) + 1;

                    max = Math.max(max, curr[c]);
                }
            }
            dp = curr;
        }
        return max * max;
    }

    /*
     * TC: O(mn)
     * SC: O(n)
     */
    public int maximalSquare_spaceOptimize2(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // base case
        int[] dp = new int[n + 1];

        for (int r = 1; r <= m; r++) {
            int prevDiagonal = 0;
            for (int c = 1; c <= n; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    int top = dp[c];
                    int left = dp[c - 1];
                    int diagonal = prevDiagonal;
                    prevDiagonal = top;

                    dp[c] = Math.min(top, Math.min(left, diagonal)) + 1;

                    max = Math.max(max, dp[c]);
                } else {
                    // VVI: we need to reset to 0 as we are using 1D array
                    dp[c] = 0;
                }
            }
        }
        return max * max;
    }

}