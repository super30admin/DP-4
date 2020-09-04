//TC: O((m*n)^2), please confirm!
//SC: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        boolean flag = false; int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int curr = 1; flag = true;
                    
                    while(i+curr < m && j+curr < n && flag){
                        //column check
                        for(int k = i+curr; k >= i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false; break;
                            }
                        }
                        //row check
                        for(int k = j+curr; k >= j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false; break;
                            }
                        }
                        if(flag) curr++;
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max*max;
    }
}
