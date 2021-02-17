// Time Complexity : The time complexity is O(mn) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int max = Integer.MIN_VALUE;

        // Maximum square possible at each cell
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                // Form square with up, down and diagonal 1s
                if(matrix[i][j] == '1'){
                    int up = i == 0 ? 0 : matrix[i-1][j] - '0';
                    int left = j == 0 ? 0 : matrix[i][j-1] - '0';
                    int diag = i == 0 || j == 0 ? 0 : matrix[i-1][j-1] - '0';
                    int cur = 1+Math.min(up, Math.min(left,diag));
                    matrix[i][j] = (char)(cur+'0');
                    max = Math.max(max,cur);
                }
            }
        }

        return max*max;

    }
}
