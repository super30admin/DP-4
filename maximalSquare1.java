//Time complexity: O(mn)^2
//Space complexity: O(1)

//brute force approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int curr = 0, max = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean flag = false;
                if(matrix[i][j] == '1'){
                    flag = true;
                    curr = 1;
                    
                    //check out of bounds
                    while(i + curr < m && j + curr < n && flag){
                        //column check
                        for(int k = i + curr; k >= i; k--){
                            if(matrix[k][j + curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //row check
                        for(int k = j + curr; k >= j; k--){
                            if(matrix[i + curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag) curr++;
                    }
                    
                }
                max = Math.max(max, curr);
            }
        }
        
        return max*max;
    }
}