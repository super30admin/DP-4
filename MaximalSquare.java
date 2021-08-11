// Time Complexity : O( (m * n) ^ 2)
// Space Complexity : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int res =  0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    boolean flag = true;
                    int cur = 1;
                    while(i + cur < m && j + cur < n && flag){
                        //diagonal up
                        for(int k = i + cur; k >= i; k--){
                            if(matrix[k][j + cur] != '1'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j + cur; k >= j; k--){
                            if(matrix[i + cur][k] != '1'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            cur++;
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res * res;
    }
}