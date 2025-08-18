// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : start at bottom right corner. For each 1, no. of squares possible at right cell, right bottom cell and 
/// bottom cell, get min and add 1 to get no. of possible squares at matrix[i][j]. Return max area of such a square
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--){
                int bottom=0, right=0, bottomright=0;
                if(matrix[i][j]==49){
                    if(i!=m-1){
                        bottom = matrix[i+1][j]-48;
                    }
                    if(j!=n-1){
                        right = matrix[i][j+1]-48;
                    }
                    if(i!=m-1 && j!=n-1){
                        bottomright = matrix[i+1][j+1]-48;
                    }
                    matrix[i][j] = (char)(Math.min(bottom, Math.min(right, bottomright))+1+48);
                    max = Math.max(matrix[i][j]-48, max);
                    //System.out.print(matrix[i][j]+" ");
                }
            }
            ///System.out.println();
        }
        //System.out.println(max);
        return max*max;
    }
}