/**
 * Idea: 
 * 1. Consider each index as right bottom element of maximal square. 
 * 2. Check if 1 and count the min of left, top and top-left diag elements. Keep track of size of square for each index similarly.
 * 3. Result is the square of max of the dp array.
 * 
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n) - extra array to store square size
 */

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length < 1) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];


        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
            
        
        for(int j=0;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
            
        
        // traverse whole matrix

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }


        return max*max;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Maximal Square");
        char matrix[][] = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        MaximalSquare obj = new MaximalSquare();
        System.out.println(obj.maximalSquare(matrix));
    }
}