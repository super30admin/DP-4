class Solution {
    public int maximalSquare(char[][] arr) {

        int result = 0;

        int[][] matrix = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == '1'){
                    result = 1;
                    matrix[i][j] = 1;
                } else matrix[i][j] = 0;
            }
        }
        
        for(int row = matrix.length-2; row > -1; row--){
            for(int col = matrix[row].length-2; col > -1; col--){
                if(matrix[row][col] == 0) continue;
                matrix[row][col] = 1 + Math.min(matrix[row+1][col], Math.min(matrix[row][col+1], matrix[row+1][col+1]));
                result = Math.max(result, matrix[row][col]);
            }
        }

        return result*result;
    }
}
