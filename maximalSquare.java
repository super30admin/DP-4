// tc : O(m*n)
// sc : O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] memo = new int[1+matrix.length][1+matrix[0].length];
        int res =0;
        for(int i =matrix.length-1 ; i>=0 ;i--){
            for(int j = matrix[0].length-1 ; j>=0 ;j--){
                if(matrix[i][j]=='1'){
                    memo[i][j]=1+Math.min(memo[i+1][j+1],Math.min(memo[i][j+1],memo[i+1][j]));
                    res= Math.max(res,memo[i][j]);
                }
            }
        }
        return res*res;
    }
}
