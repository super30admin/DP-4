// This solutions uses a 1-D dp array and basically updates the value at an index with 1 value extra of the min of the element in prev row and previous col and diagonal up
// If all of them are non zeros this will end up forming square with one additional row and col. At the end we will return the area of the square
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length+1];
        int max = 0, temp = 0, temp1 = 0;
        for(int i=1;i<matrix.length+1;i++) {
            for(int j=1;j<matrix[0].length+1;j++) {
                if(matrix[i-1][j-1]=='1') {
                    temp1 = dp[j];
                    dp[j] = (Math.min(Math.min(dp[j-1], temp), dp[j])+1);
                    temp = temp1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max*max;
    }
}
