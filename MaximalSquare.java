//The idea here is to use bottom-up dp to store the values of repeated subproblems in a dp matrix
//We start from bottom of the matrix and whenever we encounter a 1, we check the minimum of three neighbors for that index in dp array and add one to it and place it back in the index in dp array
//We also keep the track of maximum when traversing to get the maximum square side.
//We return the square of the side once traversed.
//Time complexity: O(m*n)
//Space complexity: O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i][j+1]));
                    max = Math.max(max, dp[i][j]);
                }        
            }
        }
        return max * max;
    }
}

//Here we use the same approach as above but we optimize the space by taking dp array as a 1d array.
//Time complexity: O(m*n)
//Space Complexity: O(n)
class Solution1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = m-1; i>=0; i--){
            int diagDown = 0;
            for(int j = n-1; j>=0; j--){
                int temp = dp[j];
                if(matrix[i][j] == '1'){                    
                    dp[j] = 1 + Math.min(dp[j], Math.min(diagDown, dp[j+1]));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagDown = temp;        
            }
        }
        return max * max;
    }
}