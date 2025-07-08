//start from last row and last column. Take minimum between right, bottom and bottom right diagonal and add 1 (if the current is 1). That is the size of square formed by that particular position element. Maintain a dp matrix to keep a check of previous sizes.
//Time complextity: O(m*n)
//Space complexity: O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[] = new int[n + 1];
        for(int i = m-1; i>=0; i--) {
            int diagDown = 0;
            for(int j = n-1; j>=0; j--) {
                int temp = dp[j];
                if(matrix[i][j] == '1') {
                    dp[j] = 1 + Math.min(dp[j + 1], Math.min(dp[j], diagDown));
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }
                diagDown = temp;
            }
        }
        return max * max;
    }
}