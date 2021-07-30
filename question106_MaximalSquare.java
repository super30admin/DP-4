package DynamicProgramming4;

public class question106_MaximalSquare {
    /* Created by palak on 7/19/2021 */

    /*
    Brute Force Solution:
        Time Complexity: O(mn) ^ 2
        Space Complexity: O(1)
    */
    public int maximalSquareBruteForce(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                boolean flag = false; // if '0' flag will be false
                if(matrix[i][j] == '1') {
                    int curr = 1; // the length of the diagonal we are taking currently is 1
                    flag = true;
                    while(i + curr < m && j + curr < n && flag) {
                        //column from the diagonal whose indices are i + curr && j + curr;
                        //traversing in opp. direction
                        for(int k = i + curr ; k >= i ; k--) {
                            if(matrix[k][j + curr] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        //row from the diagonal down whose indices are i + curr && j + curr;
                        //traversing in opp. direction
                        for(int k = j + curr ; k >= j ; k--) {
                            if(matrix[i + curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        // only if the flag is true then only we will increase current.
                        if(flag) {
                            curr++;
                        }
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max*max;
    }


    /*
    Dynamic Programming Solution using DP Matrix:
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    /*
    Dynamic Programming Solution using DP Array:
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */
    public int maximalSquare3(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[] = new int[n+1];
        int prev = 0;   //diagonal up
        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(matrix[i-1][j-1] == '1') {
                    int temp = dp[j];
                    dp[j] = Math.min(dp[j-1], Math.min(dp[j], prev)) + 1;
                    prev = temp;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {

    }
}
