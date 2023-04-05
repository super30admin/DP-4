class Solution {
    
    
    //Approach 4, DP Approach
    //Time Complexity: O(m*n)
    //Space Complexity: O(1)
    
//     public int maximalSquare(char[][] matrix) {
     
//         if(matrix == null || matrix.length == 0) return 0;
        
//         int maxSquare = 0;
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         for(int i=0; i<m; i++){
//             if(matrix[i][0] == '1'){
//                 maxSquare = 1;
//                 break;
//             }
//         }
        
        
//         for(int j=0; j<n; j++){
//             if(matrix[0][j] == '1'){
//                 maxSquare = 1;
//                 break;
//             }
//         }
        
//         for(int i=1; i < m; i++){
//             for(int j=1; j < n; j++){
                
//                 if(matrix[i][j] == '1'){
                    
//                     int top = matrix[i-1][j] - '0';
//                     int topLeft = matrix[i-1][j-1] - '0';
//                     int left = matrix[i][j-1] - '0';
                    
//                     int temp = 1 + Math.min(top, Math.min(topLeft, left));
//                     maxSquare = Math.max(temp, maxSquare);
                    
//                     matrix[i][j] = (char)(temp + '0');
//                 }
//             }
//         }
//         return maxSquare * maxSquare;     
//     }
    
    
    
    
    
    //Approach 3, DP Approach
    
    //Time Complexity: O(m*n)
    //Space Complexity: O(n)

    public int maximalSquare(char[][] matrix) {
        
        int maxSquare = 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        //int diagUp = 0;
        
        int[] dp = new int[n+1]; 
         
        for(int i=1; i<=m; i++){
            
            int diagUp = 0;
            
            for(int j=1; j<=n; j++){
                
                if(matrix[i-1][j-1] == '1'){
                    
                    int temp = dp[j];
                    
                    dp[j] = 1 + Math.min(
                        diagUp,
                        Math.min(
                            dp[j], dp[j-1]
                        )
                    );                  
                    diagUp = temp;
                    maxSquare = Math.max(maxSquare, dp[j]);
                }
                else{
                    dp[j] = 0;
                } 
            }
            //System.out.println(diagUp);
            //System.out.println(Arrays.toString(dp));
        }
        return maxSquare * maxSquare;
    }
    
    
    
    
    //Approach 2, DP Approach
    
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    
    
//      public int maximalSquare(char[][] matrix) {
        
//         int maxSquare = 0;
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         int[][] dp = new int[m+1][n+1]; 
         
//         for(int i=1; i<=m; i++){
//             for(int j=1; j<=n; j++){
                
//                 if(matrix[i-1][j-1] == '1'){
                    
//                     dp[i][j] = 1 + Math.min(
//                         dp[i-1][j-1],
//                         Math.min(
//                             dp[i-1][j], dp[i][j-1]
//                         )
//                     );                  
                    
//                     maxSquare = Math.max(maxSquare, dp[i][j]);
//                 }       
//             }
//         }
//         return maxSquare * maxSquare;
//     }
    
    
    
    
    
     
    
    //Approach 1, Brute-force Approach, Time Limit exceed error
    
    //Time Complexity: O(m*n*min(m,n)*min(m,n))
    //Space Complexity: O(1)
    
    
//     public int maximalSquare(char[][] matrix) {
        
        
//         if(matrix == null || matrix.length == 0) return 0;
        
//         int maxSquare = 0;
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         for(int i=0; i<m; i++){
            
//             for(int j=0; j<n; j++){
                
//                 if(matrix[i][j] == '1'){
                    
//                     int l = 1;
//                     boolean valid = true;
                    
//                     while(i+l<m && j+l<n && valid){
                        
//                         for(int row = i+l; row>=i; row--){
                            
//                             if(matrix[row][j+l] == '0'){
//                                 valid = false;
//                                 break;
//                             }
//                         }
                        
//                         for(int col = j+l; col>=j; col--){
                            
//                             if(matrix[i+l][col] =='0'){
//                                 valid = false;
//                                 break;
//                             }
//                         }
//                         if(valid) l++;  
//                     }
//                     maxSquare = Math.max(maxSquare, l);
//                 }
//             }
//         }
//         return maxSquare * maxSquare;
//     }
}
