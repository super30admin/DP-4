// Time Complexity: O(m*n)
// Space Complexity: O(1)
// Problem faced: Followed lecture for implementation. 
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int curlen = 0;
        int cols = matrix[0].length;
        boolean flag = false;
        int maxLen = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    curlen = 1;
                    flag = true;
                    while(i + curlen < rows && j + curlen < cols && flag){  
                        for(int k = i; k <= i+ curlen; k++){
                            if(matrix[k][j+curlen] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j; k <= j+ curlen; k++){
                            if(matrix[i+curlen][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) curlen++;
                    }
                  maxLen = Math.max(maxLen, curlen);
                }
            }
        }
        return maxLen*maxLen;
    }
}