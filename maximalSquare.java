/**
 * Brute Force: Algo # For each ele in the matrix, traverse thr the diagonal and check the maximum square that can be formed.
 * Time: O(m^2 * n^2) m & n are the length of row and col of given amtrix
 * Space: O(1)
 */
class Solution {
    public int maximalSquare(char[][] m) {
        if(m == null || m.length == 0) return 0;
        int diag = 1, max = 0;
        boolean flag = true;
        for(int i = 0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j] == '1'){
                    diag = 1;
                    flag = true;
                    max = Math.max(max,diag);
                    while(i+diag < m.length && j+diag < m[0].length && flag){
                        //iterate the col
                        for(int k=i+diag;k>=i && flag ;k--){
                            if(m[k][j+diag] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        //System.out.println(i+" "+j+ " "+ flag);
                        //iterate the row
                        for(int k=j+diag;k>=j && flag;k--){
                            if(m[i+diag][k] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        diag++;
                        if(flag) max = Math.max(max,diag);
                    }
                    //System.out.println(m[i][j] + " "+ max);
                }
            }
        }
        return max*max;
    }
}

/**
 * DP solution: Algo - For every ele check the top, left and top left corner ele , get the min value and add one - store it in dp array
 * Time: O(m*n)
 * Space: O(m*n)
 */
class Solution {
    public int maximalSquare(char[][] m) {
        if(m == null || m.length == 0) return 0;
        int[][] dp = new int[m.length+1][m[0].length+1];
        int max = 0;
        //making the first row and col as 0
        for(int i=0;i<m[0].length;i++)
            dp[0][i] = 0;

        for(int i=0;i<m.length;i++)
            dp[i][0] = 0;

        // check the top and left with the ele , get the min value ..add 1 to that and store it
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(m[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(m[i-1][j-1],Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;

    }
}