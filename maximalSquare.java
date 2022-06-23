// Time Complexity : O(mn) - 
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] side = new int[m+1][n+1];
        int max = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    side[i][j] = Math.min(side[i-1][j],Math.min(side[i][j-1], side[i-1][j-1]))+1;
                    max = Math.max(side[i][j], max);
                }
            }
        }
        return max*max;
    }
}