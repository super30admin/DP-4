//Bruteforce
//Time complexity m power2 n power 2
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length; int m = matrix[0].length;
        int max = 0;
        
        for(int i =0; i< n; i++){
            for(int j =0; j<m; j++){
                boolean flag = false;
                if(matrix[i][j] == '1'){
                    int curr = 1;
                    flag = true;
                    while(i + curr < n && j + curr < m && flag){ 
                        for(int k =i+curr; k>=i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j +curr; k >= j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
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
