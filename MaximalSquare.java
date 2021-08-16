class MaximalSquare {
    //Time: O(m*n)
    //space : O(n)
    //did it run successfully on leetcode: yes
    public int maximalSquare(char[][] matrix) {
        //if empty matrix, return 0
        if(matrix.length == 0 || matrix==null) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        //initialize dp array to store max side square at a location
        int[] dp = new int[n+1];
        //initialize global max
        int max = 0;
        //initializing the left diagonal element 
        int prev = 0;
        //looping through the matrix
        for(int i=1;i<=m;i++){
            for(int j=1; j<=n; j++){
                //if "1" is found
                if(matrix[i-1][j-1]=='1'){
                    //store current dp value at current location
                    int tmp = dp[j];
                    //update dp value at current location
                    dp[j] = Math.min(Math.min(dp[j], dp[j-1]), prev) + 1;
                    //update global max
                    max = Math.max(max, dp[j]);
                    //update left diagonal element
                    prev = tmp;
                }
                else{//if "1" not found
                    //we can't have any square at current location
                    dp[j]=0;
                }
                
            }
        }
        
        return max*max;
    }
     
}