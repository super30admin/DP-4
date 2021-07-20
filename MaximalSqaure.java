/*SC   - O(1) TC (M^2 * N^2)
 * */




class Solution {
    public int maximalSquare(char[][] matrix) {
        // brute force 
        // for every element, we find the maximal square starting that element at top left , move digonally bottom and inspect the square formed brtween top left and bottm right
        
        int m  = matrix.length;
        int n = matrix[0].length;
        int max =  Integer.MIN_VALUE;
       
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                   boolean flag = true;
                    // start inspecting the bottom diagonal 
                    int curr = 1;
                    while(i+curr < m &&  j+curr < n && flag){
                        
                        // check rows in col j+curr 
                        for (int  k = i+curr ; k >=i; k--){
                            if (matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        
                        /// check cols in row i+curr
                        for (int k = j+curr; k >= j ; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                       if(flag) curr +=1;  
                    }
                     max = Math.max(max, curr);
                }
            
                
            }
        }
        return max*max;
        
    }
}


// dp Approach  tc, sc - o(M*N) 
class Solution {
    public int maximalSquare(char[][] matrix) {
        // DP 
        int rows  = matrix.length;
        int cols  = matrix[0].length;
        int [][] dp = new int[rows+1][cols+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i < dp.length; i++){
            for (int j = 1 ;  j < dp[0].length; j++){
                // find min of left, top nad diagoanlly up left
                if (matrix[i-1][j-1] == '1'){ // original matrix 
                      dp[i][j]  = Math.min( dp[i-1][j], Math.min( dp[i-1][j-1], dp[i][j-1])) +1;
                    max = Math.max(max, dp[i][j]);
                }   
                
            }
                
        }
        
        return max*max;
    }
}

