// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Brute force
// 1. For every element which is '1' we will check if its diagonal element is '1' 
// 2. We will initialize current side as 1.
// 3. Now for every diagonal element we will check its neighbor in row(left) and col(up) are '1'.
// 4. If all the neighbors are '1' we increment current and check next diagonal element.
// Time Complexity : O((n*m)^2)
//      n: number of rows
//      m: number of cols
// Space Complexity : O(1)
//      In place checks
class Problem1S1 {

    /** find maximal square 's Area */
    public int maximalSquare(char[][] matrix) {

        // initialize side value
        int maxVal = 0;

        // edge case
        if(matrix == null || matrix.length == 0)
            return maxVal;
        
        // intitialize
        int n = matrix.length;
        int m = matrix[0].length;
        boolean flag = false;

        // current side value
        int current = 0;
        
        // iterate rows
        for(int i=0; i<n; i++){
            
            // iterate cols
            for(int j=0; j<m ; j++){
                
                // check it is '1'
                if(matrix[i][j] == '1'){

                    flag = true;
                    current = 1; // side value

                    // go diagonal
                    while(i+current < n && j+current < m && flag){
                        
                        // for diagonal, check its left side neighbor elements
                        for(int k =i+current; k >= i; k-- ){
                            if(matrix[k][j+current] =='0'){
                                flag = false;
                                break;
                            }
                        }
                       
                        // for diagonal, check its above neighbor elements
                        for(int k =j+current; k >= j; k-- ){
                            if(matrix[i+current][k] =='0'){
                                flag = false;
                                break;
                            }
                        }
                        // update current 
                        if(flag)
                            current++;
                    
                    }
                    // get max value for side
                    maxVal = Math.max(maxVal, current);
                }
            }
            
        }
        // return area (side *side )
        return maxVal*maxVal; 
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Dynamic programming
// 1. For every element which is '1' we will add minimum value from its neighbor.
// 2. A neighbor of cell is up, left and diagonal.
// 3. Compare with gobal max. This should be max side.
// Time Complexity : O(n*m)
//      n: number of rows
//      m: number of cols
// Space Complexity : O(n*m)
//      n: number of rows
//      m: number of cols
//    Dp matrix
class Problem1S2 {

    /** find maximal square 's Area */
    public int maximalSquare(char[][] matrix) {
        // initialize side value
        int maxVal = 0;

        // edge case
        if(matrix == null || matrix.length == 0)
            return maxVal;
        
        // initialize  and add 1 as we need 1 row and col extra
        int n = matrix.length +1;
        int m = matrix[0].length +1;

        // initilaize dp matrix
        int[][] dp =  new int [n][m];

        // iterate 
        for(int i=1; i<n; i++){
            for(int j=1; j<m;j++){
                // matrix index's is dp's index-1
                if(matrix[i-1][j-1] == '1'){

                    // take minimum of 3 side (up, left, diagonal)
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    // take max side value
                    maxVal = Math.max(maxVal, dp[i][j]);
                }
            }
            
        }
        // return area
        return maxVal*maxVal;
        
    }
}