/*
Time Complexity: O(N*M), N is number of row and M is the number cols
Space Complexity: O(N*M), size of DP array
Run on leetcode: yes
Any difficulties: no

Approach:
1. Dividing problem into sub problems of 1's size square and the moving right, down and diagonal inorder to get the
all the 1 sided squares using dynamic programming
 */
public class MaximalSquare {

    public static int maximalSquareArea(char[][] matrix){
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i = 0; i<matrix.length; i++){
            dp[i][0] = matrix[i][0]-'0';
            result = Math.max(dp[i][0], result);
        }
        for(int j = 0; j<matrix[0].length; j++){
            dp[0][j] = matrix[0][j]-'0';
            result = Math.max(dp[0][j], result);
        }

        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int min = Math.min(dp[i-1][j], dp[i][j-1]); // down row and right-hand side column
                    min = Math.min(min, dp[i-1][j-1]); // Diagonal element
                    dp[i][j] = min+1;
                    result = Math.max(result, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return result*result;
    }

    public static void main(String[] args){
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println("Maximal Square: "+ maximalSquareArea(matrix));
    }
}
