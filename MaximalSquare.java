public class MaximalSquare {
    //https://leetcode.com/problems/maximal-square/
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    //Space Optimized DP
    // TC - O(m*m) // SC O(n)
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp  = new int[n+1];
        for (int i = 1; i <m+1; i++) {
            int diagUp = 0;
            for (int j = 1; j <n+1; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=1+Math.min(dp[j-1],Math.min(dp[j],diagUp));
                    max = Math.max(max,dp[j]);
                }
                else dp[j]=0;
                diagUp=temp;
            }
            
        }
        return max*max;
    }


        //TC O(m*n) // SC O(m*n)
    /*
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1+Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }*/

    //Brute force
    //TC - O(m*n)^2 //SC O(1)
    /*
    public static int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    int cur=0;
                    boolean flag = true;
                    while (i+cur < m && j+cur <n && flag){
                        for (int k = j+cur; k >=j ; k--) {
                            if(matrix[i+cur][k]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        for (int k = i+cur; k >=i ; k--) {
                            if(matrix[k][j+cur]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if(flag) cur++;
                        max = Math.max(max,cur);
                    }
                }
            }
        }



        return max*max;
    }*/
}
