// Time Complexity : O(mn 2) (mn square) for Brute Force approach
//Time Complexity : O(mn) for DP approach
// Space Complexity : O(1) for Brute Force approach
// Space Complexity : O(mn) for DP approach. DP matrix will take additional space. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Brute Force Approach -> Whenever you encounter a 1 in the matrix, traverse diagonally, and check if the square created has all 1's or not.
//DP Solution - For corresponding 1's in the original matrix, populate DP Matrix using the values on Min( top, left and topleft) + 1.
//Dp Matrix will be m+1 and n+1 size; where row 0 and col 0 will be instantiated with 0's.


class Solution {

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dpArray = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(matrix[i-1][j-1] == '1') {
                    int left = dpArray[i-1][j];
                    int top = dpArray[i][j-1];
                    int topLeft = dpArray[i-1][j-1];
                    int val = Math.min(Math.min(left,top),topLeft);
                    dpArray[i][j] = val + 1;
                    max = Math.max(val+1,max);
                }

            }
        }
        return max*max;

    }
    public int maximalSquareBF(char[][] matrix) {

        if(matrix == null || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(matrix[i][j] == '1') {
                    int count = 1;
                    int r = i + 1;
                    int c = j + 1;
                    //Explore diagonal
                    while(r < m && c <n && matrix[r][c] == '1') {

                        //Explore the col
                        boolean bValid = true;
                        for(int k = r; k >= i; k--){
                            if(matrix[k][c] == '0') {

                                bValid = false;
                                break;
                            }
                        }
                        //Explore the row
                        for(int k = c; k >= j; k--){
                            if(matrix[r][k] == '0') {

                                bValid = false;
                                break;
                            }
                        }

                        if(!bValid) {
                            break;
                        }
                        r++;
                        c++;
                        count++;
                    }
                    max = Math.max(max,count);
                }
            }
        }

        return max * max;
    }
}
