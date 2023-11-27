/* Time Complexity : O(m^2*n^2)) 
 *  m - rows - matrix 
 *  n - cols - matrix */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//BruteForce

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        //Iterate over the matrix to find '1'
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    boolean flag = true;
                    while(flag && i+l < m && j+l < n){
                        //col check - ele above current ele
                        for(int k = i+l; k >= i; k--){
                            if(matrix[k][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        //row check - ele left of current ele
                        for(int k = j+l; k >= j; k--){
                            if(matrix[i+l][k] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            l++;
                        }
                    }
                    maxLen = Math.max(maxLen, l);
                }
            }
        }
        return maxLen * maxLen;
    }
}