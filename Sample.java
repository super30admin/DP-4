// Problem-1: Maximal Square
/**
Dp solution.
TC = O(m*n)
SC = O(m*n)
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m=matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i< m+1; i++){
            for(int j=1; j < n+1; j++){
                if(matrix[i-1][j-1] == '1'){ // if the valid element is there in the original matrix
                    dp[i][j] = 1 + Math.min( dp[i-1][j-1], Math.min( dp[i-1][j] , dp[i][j-1]));                    
                }
                    max = Math.max(max, dp[i][j]);
                
            }
        }
        
        return max*max;
        
    }
}

// Iterative
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max=0;
        boolean flag;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                
                if(matrix[i][j] == '1'){
                    flag = true;
                    int c = 1;
                    
                    while(i+c < matrix.length && j+c < matrix[0].length && flag){
                        for(int k = i+c; k >= i; k--){ // iterating ove the rows until the boundary (i) is seen
                            if(matrix[k][j+c] == '0'){ 
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j+c; k >= j; k--){ // iterating ove the cols until the boundary(j) is seen
                            if(matrix[i+c][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag){
                            c++;
                        }
                    }
                        max = Math.max(max, c);
                    
                }
                
            }
        }
        return max*max;
    }
}

// Problem-2: Partition Array for Maximum Sum
// TC = O(n*k) where n is the num of elements in arr A and k is the max partition
// SC = O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        if(A == null || A.length == 0) return 0;
        
        int [] dp = new int[A.length];
        for(int i=0; i< dp.length; i++){
            int max=0;
            
            for(int j=1; i-j+1 >=0 && j<=K; j++){
                max = Math.max(max, A[i-j+1]);
                
                if(i >=j){
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }else{
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        
        return dp[dp.length-1];
    }
}
