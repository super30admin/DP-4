class Solution {
    // Bruteforce solution
    // Time complexity is O(mn)^2
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero error
    public int maximalSquare(char[][] matrix) {
        
        // Make a max global variable
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    boolean flag = true;
                    while(i+l < m && j+l < n && flag){
                        // Colomn check
                        for(int k = i+l; k>=i;k--){
                            if(matrix[k][j+l] =='0') {
                                flag = false;
                                break;
                            } 
                        }
                        
                        // row check
                        for(int o = j+l; o>=j;o--){
                            if(matrix[i+l][o] =='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) l++;
                    }
                    max = Math.max(max,l);
                }
            }
        }
        return max*max;
    }
}