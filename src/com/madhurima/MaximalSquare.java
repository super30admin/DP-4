//Time complexity: O(m*n)^2 for brute force, O(m*n) for dp approach
//Space Complexity: O(1) for brute force, O(m*n) for solution 2 and O(n) for solution 3
//Did the code run successfully in LeetCode = yes


package com.madhurima;

public class MaximalSquare {
}

class MaximalSquare1 {

    //brute force approach
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max =0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int curr = 0;
                    boolean flag = true;
                    while(i+curr < m && j+curr < n && flag){
                        //need to check all rows in same col
                        for(int k = i+curr; k >= i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        //need to check for all cols in same row
                        for(int k = j+curr; k >= j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            curr++;
                        }


                    }

                    max = Math.max(max, curr);

                }
            }
        }

        return max*max;
    }
}

class MaximalSquare2 {
    //dp with extra space of O(m*n)
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int[][] dp = new int [m+1][n+1];

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        return max*max;

    }
}

class MaximalSquare3 {
    //dp with extra space of O(n) only
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int [n+1];

        for(int i = 1; i < m+1; i++){
            int diagUp = 0;
            for(int j = 1; j < n+1; j++){
                int temp  = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], diagUp));
                    max = Math.max(max, dp[j]);
                }else{
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }

        return max*max;

    }
}
