//approch 1
// Time Complexity : O(m2n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//approch 2
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//approch 3
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 brute force
    public static int maximalSquare1(char[][] matrix) {
        // null case
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // to store max value;
        int max = 0;
        // first I will traverse in matrix and check if we encounters 1 then checkthe
        // maximum size of
        // the sqaure and update the max value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if we encounter 1 then
                if (matrix[i][j] == '1') {
                    // l interger for measure size of the square
                    int l = 1;
                    // boolean flag for while looop
                    boolean flag = true;
                    // here we step by step increase the l and check in each row and column
                    // there is 1 if not one we break the loop make flag false
                    // at end we check flag is true then we increase the l as we havnt encountered 0

                    while (i + l < m && j + l < n && flag) {
                        for (int k = i + l; k >= i; k--) {
                            if (matrix[k][j + l] == '0') {
                                flag = false;
                                break;

                            }
                        }
                        for (int k = j + l; k >= j; k--) {
                            if (matrix[i + l][k] == '0') {
                                flag = false;
                                break;

                            }
                        }
                        if (flag)
                            l++;
                    }
                    // update the max with maximum value
                    max = Math.max(max, l);
                }
            }
        }
        return max * max;
    }

    // approch 2 using dp matrix
    public static int maximalSquare2(char[][] matrix) {
        // null case
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        // dp matrix
        int[][] dp = new int[m + 1][n + 1];

        // traverse through matrix if we found 1 then update current element by gettting
        // minimum of
        // left, top and topleft and add 1 into it and update the max
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max * max;
    }

    // approch 3 using dpm array
    public static int maximalSquare3(char[][] matrix) {
        // null case
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // to store max value
        int max = 0;
        // dp array of size number of cols +1;
        int[] dp = new int[n + 1];

        // here we check if we encounters 1 in the matrix,
        // top and left element we are getting from the dp array
        // and we maintain another varaible to get topleft element
        // we get topleft element from the previous dp array
        // we calculate the min between this three and
        // add 1 into it and update the max value
        for (int i = 1; i <= m; i++) {
            int diagUp = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(diagUp, Math.min(dp[j - 1], dp[j]));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        System.out.println(maximalSquare1(matrix));
        System.out.println(maximalSquare2(matrix));
        System.out.println(maximalSquare3(matrix));

    }
}