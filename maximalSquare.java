
//Brute Force approach
//TC: O((mn)^2)
//SC: O(1)
//where m,n are number of rows and coloumns

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
         int curr = 0;
        int m = matrix.length,n=matrix[0].length,max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean flag = false;
                if(matrix[i][j] == '1'){
                    flag = true;
                    curr =1;
                    while(i+curr<m && j+curr<n && flag){
                        //colCheck
                        for(int k = i+curr;k>=i;k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //rowCheck
                        for(int k = j+curr;k>=j;k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            curr++;
                    }
                }
                max = Math.max(max,curr);
            }
        }
        return max*max;
    }
}



//DP Approach
//TC: O(mn) iterating through all the elements in a matrix
//SC: O(mn) 
//where m,n are number of rows and coloumns

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length,n = matrix[0].length;
        int max=0;
        int dp[][] = new int[m+1][n+1];
        
        //fill first row and first coloumn
        
        
        //start filling the rest of dp matrix
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                 if(matrix[i-1][j-1] == '1'){
                     dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                     max = Math.max(max,dp[i][j]);
                 }
            }
        }
        return max*max;
    }
}