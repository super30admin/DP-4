// Time complexity - O((mn)^2)
// Space complexity - O(1)

// Traverse diagonally on each point.

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        boolean flag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == '1'){
                    int currDiagonalLength = 1;
                    flag = true;
                    while(i+currDiagonalLength < m && j+currDiagonalLength < n && flag){
                        // rows
                        for(int k = i+currDiagonalLength; k>= i; k--){
                            if(matrix[k][j+currDiagonalLength] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        // columns
                        for(int k = j+currDiagonalLength; k>= j; k--){
                            if(matrix[i+currDiagonalLength][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag) currDiagonalLength++;
                    }
                    max = Math.max(max,currDiagonalLength);
                }
            }
        }
        return max*max;
    }
}
