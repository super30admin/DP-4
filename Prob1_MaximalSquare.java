//TC : O(M*N)
//SC : O(M*N)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0; 
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i< dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){ //AS DP is having extra row and column so indices for matrix will be 1 lesser than indices in DP arra{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    //We will check all 3 values from DP MAtrix and adding 1 to it will be max. length of the square at currert indices i and j
                    
                    max = Math.max(dp[i][j], max); // Update the MAX length 
                }        
            }
             
        }
        return max*max;
    }
}


/*
//TC : O(M*N)
//SC : O(N) // As we are using Just one row OF SIZE N

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0; 
        
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dp = new int[n+1]; //Taking only 1 row, to calculate and overwrite the values of length of square
        
        for(int i = 1; i<= m; i++){
            int diagonal = 0; 
            for(int j = 1; j<=n; j++){
                int temp = dp[j];  //Keeping previous value of dp[j]
                if(matrix[i-1][j-1] == '1'){ //AS DP is having extra row and column so indices for matrix will be 1 lesser than indices in DP arra{
                    dp[j] = Math.min(Math.min(dp[j], dp[j-1]), diagonal) + 1;
                               Minimum from //Up   ,   Left.    and //Diagonal
                    max = Math.max(dp[j], max);
                    
                    diagonal = temp; //Putting last dp[j] in diagonal
                }else{
                    dp[j] = 0;
                }
            }
        }
        return max*max;
    }
}

*/



/*

//TC : O((M*N)(M*N))
//SC : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0; 

        int max = 0;
        boolean flag = false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                int l = 1;
                if(matrix[i][j] == '1'){ // When we find 1
                    flag = true;
                    //Check for diagonal cell and check if from that new row to current row, all are 1's in both rows and columns 
                    while(i + l < m && j + l < n && flag){
                        //Checking in left direction
                        for(int c = j + l; c >= j; c--){
                            if(matrix[i + l][c] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //Checking in up direction
                        for(int c = i + l; c >= i; c--){
                            if(matrix[c][j+l] == '0'){
                                flag = false;
                                break;
                            }   
                        }
                        
                        if(flag) l++; // If all are 1's, flag will be true and then increment the length of the square by 1
                        
                    }
                    max = Math.max(max, l); // Update the MAX length
                }
            }
        }
        
        return max*max;
    }
}


*/




