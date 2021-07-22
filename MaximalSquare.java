//Time complexity - O(m*n)^2
//Space complexity - O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge case
      if(matrix == null || matrix.length == 0) return 0;
      int max = 0;
      boolean flag = false; // flag is set to false when 0 is found
      int m = matrix.length;
      int n = matrix[0].length;
      
      for(int i = 0; i< m; i++) {
        for(int j = 0; j< n; j++) {
          if(matrix[i][j] == '1') {
            flag = true;
            int curr = 1;
            while(i+curr < m && j+curr < n && flag) {
              //traverse diagonal end to up till starting points' row
              for(int k = i+curr; k >= i; k--) {
                if(matrix[k][j+curr] == '0') {
                  flag = false;
                  break;
                }
              }
              //traverse row up to end of starting point row
              for(int k = j+curr; k>= j; k--) {
                if(matrix[i+curr][k] == '0') {
                  flag = false;
                  break;
                }
              }
             if(flag) curr ++;
            }
            max = Math.max(max,curr);
          }
        }
      }
      return max*max;
      
    }
}