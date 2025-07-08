/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(m * n)
Space Complexity - O(m * n)
Approach : DP
*/
public class Maximal_Square_LC_221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1+ Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                    max= Math.max(max, dp[i][j]);
                }
            }
        }
        return max* max;
    }
}

/*
Brute Force- TLE
Time Complexity  - O(m * n) ^2
Space Complexity - O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){ //check all surrounding 1's using right down diagonal pivot
                    //Square starts using l we will go i+1, j+1, to check the maximal square
                    int l = 1;
                    boolean flag = true;
                    while(i+l < m && j+l < n && flag) { // now we are going down the diagonal but we will have to check digonal end to top and digonal end to left start for all 1's
                        for(int r = i+l ; r >=i; r--) { //going up from digonal end till i, this will be our square frame
                            if(matrix[r][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int c = j+l ; c >=j; c--) { //going left from digonal end till j, this will be our square frame
                            if(matrix[i+l][c] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            l++;
                        }

                    }
                    max = Math.max(max, l);
                }
            }
        }
        return max * max;

    }
} */

/*
 Dp Solution- space optimised
Time complexity - O(M*N)
Space complexity - O(M)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [] dp = new int[n+1];
        int max = 0;
        for(int i = m-1; i>=0; i--) {
            int diagDown = 0;
            for(int j = n-1; j>=0; j--) {
                int temp = dp[j];
                if(matrix[i][j] == '1') {
                    dp[j] = 1+ Math.min(dp[j], Math.min(dp[j+1], diagDown));
                    max= Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagDown = temp;

            }
        }
        return max* max;
    }
}
 */