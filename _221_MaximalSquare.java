// Time Complexity : n^2 where n is row size
// Space Complexity :  n^2 where n is row size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
 //if cell is min then tale min of its left, topleft, top neighbors and add 1
class Solution {
    public int maximalSquare(char[][] matrix) {

        int max = 0;

        for(int i=0; i< matrix.length; i++){

            for(int j = 0; j< matrix[0].length; j++){

                if(i == 0 || j == 0){
                    if(matrix[i][j] == '1' && max == 0){
                        max = 1;
                    }
                }
                else{
                    if(matrix[i][j] == '1'){

                        int left = (int)(matrix[i][j-1] - '0');
                        int top = (int)(matrix[i-1][j] - '0');
                        int topLeft = (int)(matrix[i-1][j-1] - '0');

                        int val = 1 + Math.min(left, Math.min(top, topLeft));

                        max = Math.max(max, val );

                        matrix[i][j] = (char)( val + '0');

                    }
                }

            }

        }

        return max*max;
    }
}
