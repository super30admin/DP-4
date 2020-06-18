//Brute force, Minimal Square

//time o(m pow 2 n pow 2)
//space o(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
            return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean flag = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    int curr = 1;
                    flag = true;
                    while(i+curr < m && j+curr < n && flag) {
                        //column check
                        for(int k=i+curr; k>=i; k--) {
                            if(matrix[k][j+curr] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        //row check
                        for(int k=j+curr; k>=j; k--) {
                            if(matrix[i+curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            curr++;
                        }
                    }
                    max = Math.max(max,curr);
                }
            }
        }
        return max*max;
    }
}

//time efficiency DP solution
//time o(mn)
//space o(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
            return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i< dp.length;i++) {
            for(int j=1; j< dp[0].length;j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                            Math.min(dp[i][j-1], dp[i-1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}